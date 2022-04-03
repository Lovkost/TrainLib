package com.example.trainlib.presentation.users

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UsersPresenterAssistedFactory {

    fun create(): UsersPresenter

}