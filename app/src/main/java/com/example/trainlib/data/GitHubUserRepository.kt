package com.example.trainlib.data

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}