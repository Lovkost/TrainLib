package com.example.trainlib.data.repository.datasource

import com.example.trainlib.api.GitHubApi
import com.example.trainlib.data.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

class GitHubUserDataSourceImpl
@Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()
            .delay(2L, SECONDS)

    override fun getUserByLogin(login: String): Maybe<GitHubUser> =
        gitHubApi
            .fetchUserByLogin(login)
            .onErrorComplete()

}