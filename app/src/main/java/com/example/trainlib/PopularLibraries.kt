package com.example.trainlib

import android.app.Application
import com.example.trainlib.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class PopularLibraries : Application() {

    companion object Navigation {

        private val cicerone : Cicerone<Router> by lazy {
            Cicerone.create()
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }

}