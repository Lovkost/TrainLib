package com.example.trainlib.data

import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val users = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
    )

    override fun getUsers() =
        Single.just(users)

    override fun getUserByLogin(userId: String): GitHubUser? =
        users.firstOrNull { user -> user.login == userId }

}