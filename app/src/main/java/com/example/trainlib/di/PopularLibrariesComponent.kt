package com.example.trainlib.di

import android.content.Context
import com.example.trainlib.PopularLibraries
import com.example.trainlib.data.schedulers.Schedulers
import com.example.trainlib.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, UserModule::class])
interface PopularLibrariesComponent : AndroidInjector<PopularLibraries> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        @BindsInstance
        fun withRouter(router: CustomRouter): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): PopularLibrariesComponent

    }

}