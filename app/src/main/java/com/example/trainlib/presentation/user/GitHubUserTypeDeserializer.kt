package com.example.trainlib.presentation.user

import com.example.trainlib.data.GitHubUser
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class GitHubUserTypeDeserializer : JsonDeserializer<GitHubUser.Type> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GitHubUser.Type {
        return when (json?.asString?.lowercase()) {
            "user" -> GitHubUser.Type.USER
            "administrator" -> GitHubUser.Type.ADMINISTRATOR
            else -> GitHubUser.Type.UNKNOWN
        }
    }
}