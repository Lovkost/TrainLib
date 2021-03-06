package com.example.trainlib.data.repository.datasource

import com.example.trainlib.data.GitHubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GitHubUserCacheDataSource {

    fun getUsers(): Observable<List<GitHubUser>>
    fun getUserByLogin(login: String): Observable<GitHubUser>
    fun retain(users: List<GitHubUser>): Observable<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>

}