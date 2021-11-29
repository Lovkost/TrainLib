package com.example.trainlib.api

import com.example.trainlib.data.GitHubUser
import com.example.trainlib.presentation.user.GitHubUserTypeDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GitHubApiFactory {
    private val gson: Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(GitHubUser.Type::class.java, GitHubUserTypeDeserializer())
            .create()

    private val gitHubApi: GitHubApi by lazy {
        Retrofit.Builder()
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
    }

    fun create(): GitHubApi = gitHubApi
}