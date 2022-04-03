package com.example.trainlib.di

import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.data.GitHubUserRepositoryImpl
import com.example.trainlib.data.repository.datasource.*
import com.example.trainlib.presentation.MainActivity
import com.example.trainlib.presentation.user.UserFragment
import com.example.trainlib.presentation.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NetworkModule::class, StorageModule::class])
interface UserModule {

    @ContributesAndroidInjector
    fun bindMainFragment(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @Binds
    fun bindGitHubUserRepository(
        gitHubUserRepository: GitHubUserRepositoryImpl
    ): GitHubUserRepository

    @Binds
    fun bindGitHubUserDataSource(
        gitHubUserDataSource: GitHubUserDataSourceImpl
    ): GitHubUserDataSource

    @Binds
    fun bindGitHubUserCacheDataSource(
        gitHubUserCacheDataSource: GitHubUserCacheDataSourceImpl
    ): GitHubUserCacheDataSource

    @Binds
    fun bindGitHubRepositoryDataSource(
        gitHubRepositoryDataSource: GitHubRepositoryDataSourceImpl
    ): GitHubRepositoryDataSource

    @Binds
    fun bindGitHubRepositoryCacheDataSource(
        gitHubRepositoryCacheDataSource: GitHubRepositoryCacheDataSourceImpl
    ): GitHubRepositoryCacheDataSource

}