package com.example.trainlib.data

import com.example.trainlib.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUser(userId: String): Observable<GitHubUser>

    fun getUserRepositories(login: String): Observable<List<GitHubRepository>>
}