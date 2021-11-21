package com.example.trainlib.presentation.users

import com.example.trainlib.data.GitHubUser
import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.presentation.navigation.CustomRouter
import com.example.trainlib.presentation.user.UserScreen
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}