package com.c16.flywithme.viewmodel

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.data.user.use_case.UserUseCase
import com.c16.flywithme.data.user.preference.UserPreference
import com.c16.flywithme.di.Injection
import com.c16.flywithme.presentation.ui.login.LoginViewModel

class ViewModelFactory(
    private val userUseCase: UserUseCase,
    private val pref: UserPreference,
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
//            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(
//                pref
//            ) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(
                userUseCase, pref
            ) as T
//            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> RegisterViewModel(
//                userUseCase
//            ) as T
//            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(
//                userUseCase, pref
//            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context, pref: DataStore<Preferences>): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideUserUseCase(),
                    UserPreference.getInstance(pref),
                )
            }.also { instance = it }
    }
}