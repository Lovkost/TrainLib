package com.example.trainlib.presentation

import android.R
import android.content.Intent
import android.os.Bundle
import com.example.trainlib.PopularLibraries.Navigation.navigatorHolder
import com.example.trainlib.PopularLibraries.Navigation.router
import com.example.trainlib.presentation.navigation.CustomNavigator
import com.example.trainlib.presentation.users.UsersScreen
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.content)

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