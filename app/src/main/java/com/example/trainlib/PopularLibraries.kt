package com.example.trainlib

import android.app.Application
import com.example.trainlib.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone

class PopularLibraries : Application() {

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }

}