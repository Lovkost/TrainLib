package com.example.trainlib.data.repository.datasource

import com.example.trainlib.api.GitHubApi
import com.example.trainlib.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubRepositoryDataSourceImpl
@Inject constructor(
    private val gitHubApi: GitHubApi
): GitHubRepositoryDataSource {

    override fun getUserRepositories(userId: String): Single<List<GitHubRepository>> =
        gitHubApi
            .fetchUserRepositories(userId)

}