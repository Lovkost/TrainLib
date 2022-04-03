package com.example.trainlib.presentation.user

import com.example.trainlib.data.GitHubUserRepository
import com.example.trainlib.data.schedulers.Schedulers
import com.example.trainlib.presentation.GitHubUserViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class UserPresenter
@AssistedInject constructor(
    @Assisted("login") private val userLogin1: String,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            Observable.merge(
                userRepository
                    .getUser(userLogin1)
                    .map(GitHubUserViewModel.Mapper::map)
                    .observeOn(schedulers.main())
                    .doOnNext(viewState::showUser),
                userRepository
                    .getUserRepositories(userLogin1)
                    .observeOn(schedulers.main())
                    .doOnNext(viewState::showRepositories)
            )
                .subscribeOn(schedulers.background())
                .subscribe({}, viewState::showError)
    }

    override fun onDestroy() {
        disposables.clear()
    }

}