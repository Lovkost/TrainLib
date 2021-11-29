package com.example.trainlib.data

import com.example.trainlib.api.GitHubApi
import com.example.trainlib.api.GitHubApiFactory
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi = GitHubApiFactory.create()
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi
            .fetchUserByLogin(userId)
            .onErrorComplete()

}