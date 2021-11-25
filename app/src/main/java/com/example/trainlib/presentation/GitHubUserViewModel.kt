package com.example.trainlib.presentation

import com.example.trainlib.data.GitHubUser

data class GitHubUserViewModel(val login: String) {

    object Mapper {

        fun map(user: GitHubUser) =
            GitHubUserViewModel(user.login.uppercase())

    }

}