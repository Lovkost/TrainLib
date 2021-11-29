package com.example.trainlib.data.repository.datasource

import com.example.trainlib.data.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GitHubUserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(login: String): Maybe<GitHubUser>

}