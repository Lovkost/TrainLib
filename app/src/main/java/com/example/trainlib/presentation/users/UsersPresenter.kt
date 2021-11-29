package com.example.trainlib.presentation.users

import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.data.schedulers.Schedulers
import com.example.trainlib.presentation.GitHubUserViewModel
import com.example.trainlib.presentation.GitHubUserViewModel.Mapper
import com.example.trainlib.presentation.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<UsersView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUsers()
                .observeOn(schedulers.background())
                .map { users -> users.map(Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
    }

    fun displayUser(user: GitHubUserViewModel) {
        router.navigateTo(UserScreen(user.name))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}

