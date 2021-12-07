package com.example.trainlib.presentation.user

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface UserPresenterAssistedFactory {

    fun create(@Assisted("login") userLogin: String): UserPresenter

}