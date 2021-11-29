package com.example.trainlib.data

import com.example.trainlib.api.GitHubApi
import com.example.trainlib.api.GitHubApiFactory
import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.data.repository.datasource.GitHubRepositoryCacheDataSource
import com.example.trainlib.data.repository.datasource.GitHubRepositoryDataSource
import com.example.trainlib.data.repository.datasource.GitHubUserCacheDataSource
import com.example.trainlib.data.repository.datasource.GitHubUserDataSource
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl(
    private val gitHubUserDataSource: GitHubUserDataSource,
    private val gitHubUserCacheDataSource: GitHubUserCacheDataSource,
    private val gitHubRepositoryDataSource: GitHubRepositoryDataSource,
    private val gitHubRepositoryCacheDataSource: GitHubRepositoryCacheDataSource,
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            gitHubUserCacheDataSource
                .getUsers(),
            gitHubUserDataSource
                .getUsers()
                .flatMapObservable(gitHubUserCacheDataSource::retain)
        )

    override fun getUser(userId: String): Observable<GitHubUser> =
        Observable.merge(
            gitHubUserCacheDataSource
                .getUserByLogin(userId),
            gitHubUserDataSource
                .getUserByLogin(userId)
                .flatMapCompletable { user ->
                    gitHubUserCacheDataSource
                        .retain(user)
                        .flatMapCompletable {
                            gitHubRepositoryDataSource
                                .getUserRepositories(user.login)
                                .map { repositories -> repositories.map { repository -> repository.copy(login = user.login) }}
                                .flatMapCompletable(gitHubRepositoryCacheDataSource::retain)
                        }
                }
                .toObservable()
        )

    override fun getUserRepositories(login: String): Observable<List<GitHubRepository>> =
        Observable.merge(
            gitHubRepositoryCacheDataSource
                .getUserRepositories(login),
            gitHubRepositoryDataSource
                .getUserRepositories(login)
                .map { repositories -> repositories.map { repository -> repository.copy(login = login) }}
                .flatMapCompletable(gitHubRepositoryCacheDataSource::retain)
                .toObservable()
        )

}