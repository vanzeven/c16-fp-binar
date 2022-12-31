package com.c16.flywithme.presentation.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c16.flywithme.data.user.preference.UserPreference

class SplashViewModel(private val pref: UserPreference):ViewModel() {

    fun getIsLogin() = pref.getIsLogin().asLiveData()
}