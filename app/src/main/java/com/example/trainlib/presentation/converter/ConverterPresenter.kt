package com.example.trainlib.presentation.converter

import android.net.Uri
import com.example.trainlib.data.converter.Converter
import com.example.trainlib.data.schedulers.Schedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter


class ConverterPresenter(
    private val converter: Converter,
    private val schedulers: Schedulers
) : MvpPresenter<ConverterView>() {

    private val disposables = CompositeDisposable()

    fun convert(uri: Uri) {
        viewState.showContent(uri)
        viewState.showLoading()

        disposables +=
            converter
                .convert(uri)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showContent,
                    viewState::showError
                )
    }

    fun cancel() {
        viewState.showContent(null)
        disposables.clear()
    }

    override fun onDestroy() = disposables.clear()

}