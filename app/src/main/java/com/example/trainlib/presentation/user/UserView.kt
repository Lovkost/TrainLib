package com.example.trainlib.presentation.user

import com.example.trainlib.data.GitHubUser
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.ScreenView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : ScreenView {


    @SingleState
    fun showUser(user: GitHubUserViewModel)

}