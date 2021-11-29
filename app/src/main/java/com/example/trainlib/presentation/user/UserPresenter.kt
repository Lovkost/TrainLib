package com.example.trainlib.presentation.user

import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.presentation.GitHubUserViewModel.Mapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
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
                .map(Mapper::map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }

}