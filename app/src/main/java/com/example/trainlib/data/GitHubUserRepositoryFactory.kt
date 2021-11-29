package com.example.trainlib.data

import com.example.trainlib.api.GitHubApiFactory
import com.example.trainlib.data.repository.datasource.GitHubRepositoryCacheDataSourceImpl
import com.example.trainlib.data.repository.datasource.GitHubRepositoryDataSourceImpl
import com.example.trainlib.data.repository.datasource.GitHubUserCacheDataSourceImpl
import com.example.trainlib.data.repository.datasource.GitHubUserDataSourceImpl
import com.example.trainlib.data.storage.GitHubStorageFactory

object GitHubUserRepositoryFactory {

    private val gitHubUserRepository: GitHubUserRepository by lazy(LazyThreadSafetyMode.NONE) {
        GitHubUserRepositoryImpl(
            GitHubUserDataSourceImpl(
                GitHubApiFactory.create()
            ),
            GitHubUserCacheDataSourceImpl(
                GitHubStorageFactory.create()
            ),
            GitHubRepositoryDataSourceImpl(
                GitHubApiFactory.create()
            ),
            GitHubRepositoryCacheDataSourceImpl(
                GitHubStorageFactory.create()
            )
        )
    }

    fun create(): GitHubUserRepository = gitHubUserRepository
}