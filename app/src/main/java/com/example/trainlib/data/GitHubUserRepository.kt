package com.example.trainlib.data

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): @NonNull Single<List<GitHubUser>>?

    fun getUserByLogin(userId: String): GitHubUser?

}