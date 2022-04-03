package com.example.trainlib.presentation.users

import com.example.trainlib.data.GitHubUser
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.ScreenView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : ScreenView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUserViewModel>)

}