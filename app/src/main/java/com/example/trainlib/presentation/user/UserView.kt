package com.example.trainlib.presentation.user

import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState



    interface UserView : ScreenView {

        /**
         * Показывает информацию о пользователе.
         * @param userModel пользователь
         */
        @SingleState
        fun showUser(userModel: GitHubUserViewModel)

    }
