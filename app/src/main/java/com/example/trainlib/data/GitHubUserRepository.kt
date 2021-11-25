package com.example.trainlib.data

import io.reactivex.Maybe
import io.reactivex.Single


interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}