package com.example.trainlib.presentation.converter

import android.net.Uri
import com.example.trainlib.presentation.ScreenView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ConverterView : ScreenView {

    @AddToEndSingle
    fun showContent(uri: Uri?)

    @AddToEndSingle
    fun showLoading()

}