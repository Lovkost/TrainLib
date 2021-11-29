package com.example.trainlib.data.repository.datasource

import com.example.trainlib.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface GitHubRepositoryCacheDataSource {

    fun getUserRepositories(login: String): Observable<List<GitHubRepository>>
    fun retain(repositories: List<GitHubRepository>): Completable

}