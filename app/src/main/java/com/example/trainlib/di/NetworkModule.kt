package com.example.trainlib.di

import com.example.trainlib.api.GitHubApi
import com.example.trainlib.api.GitHubApiErrorInterceptor
import com.example.trainlib.api.GitHubApiInterceptor
import com.example.trainlib.data.GitHubUser
import com.example.trainlib.presentation.user.GitHubUserTypeDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(GitHubUser.Type::class.java, GitHubUserTypeDeserializer())
            .create()

    @Reusable
    @Provides
    fun provideGitHubApi(gson: Gson): GitHubApi {
        val create = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(GitHubApiInterceptor)
                    .addInterceptor(GitHubApiErrorInterceptor)
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GitHubApi::class.java)
        return create
    }

}