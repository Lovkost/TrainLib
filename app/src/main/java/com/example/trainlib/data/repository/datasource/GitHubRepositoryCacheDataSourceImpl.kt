package com.example.trainlib.data.repository.datasource

import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.data.storage.GitHubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Named

class GitHubRepositoryCacheDataSourceImpl
@Inject constructor(
    @Named("Persisted") private val gitHubStorage: GitHubStorage
): GitHubRepositoryCacheDataSource {

    override fun getUserRepositories(login: String): Observable<List<GitHubRepository>> =
        gitHubStorage
            .getGitHubRepositoryDao()
            .getRepositoriesByLogin(login)

    override fun retain(repositories: List<GitHubRepository>): Completable =
        gitHubStorage
            .getGitHubRepositoryDao()
            .retain(repositories)

}