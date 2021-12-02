package com.example.trainlib.presentation

import android.R
import android.content.Intent
import android.os.Bundle
import com.example.trainlib.presentation.abs.AbsActivity
import com.example.trainlib.presentation.navigation.CustomNavigator
import com.example.trainlib.presentation.navigation.CustomRouter
import com.example.trainlib.presentation.users.UsersScreen
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        router.openDeepLink(intent?.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            router.newRootScreen(UsersScreen)
            router.openDeepLink(intent?.data)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}