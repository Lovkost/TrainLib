package com.example.trainlib.presentation.user

import com.example.trainlib.data.repository.GitHubRepository
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState



    interface UserView : ScreenView {
        @SingleState
        fun showUser(user: GitHubUserViewModel)

        /**
         * Показывает информацию о репозиториях пользователе.
         * @param repositories репозитории
         */
        @SingleState
        fun showRepositories(repositories: List<GitHubRepository>)

    }
