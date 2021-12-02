package com.example.trainlib
import com.example.trainlib.data.schedulers.SchedulersFactory
import com.example.trainlib.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PopularLibraries : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerPopularLibrariesComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(SchedulersFactory.create())
            .apply {
                val cicerone = Cicerone.create(CustomRouter())
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

}