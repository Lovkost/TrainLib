package com.example.trainlib.data.repository.datasource

import com.example.trainlib.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single

interface GitHubRepositoryDataSource {

    fun getUserRepositories(userId: String): Single<List<GitHubRepository>>

}