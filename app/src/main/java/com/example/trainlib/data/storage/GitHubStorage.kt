package com.example.trainlib.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.data.repository.GitHubRepository

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepository::class], version = 1)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao
    abstract fun getGitHubRepositoryDao(): GitHubRepositoryDao

}