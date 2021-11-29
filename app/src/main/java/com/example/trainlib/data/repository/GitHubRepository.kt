package com.example.trainlib.data.repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_repositories")
data class GitHubRepository(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    val login: String,
    @SerializedName("name")
    val name: String,
)