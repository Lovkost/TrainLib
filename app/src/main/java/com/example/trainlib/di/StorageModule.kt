package com.example.trainlib.di

import android.content.Context
import androidx.room.Room
import com.example.trainlib.data.storage.GitHubStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Named("InMemory")
    @Provides
    fun provideInMemoryDatabase(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Named("Persisted")
    @Provides
    fun providePersistedDatabase(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .build()

}