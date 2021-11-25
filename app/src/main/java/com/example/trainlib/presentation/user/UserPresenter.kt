package com.example.trainlib.presentation.user

import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.presentation.GitHubUserViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserByLogin(userLogin)
                .map(GitHubUserViewModel.Mapper::map)
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }

}