package com.c16.flywithme

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.c16.flywithme.data.user.model.UserModel
import com.c16.flywithme.data.user.preference.UserPreference
import com.c16.flywithme.data.user.use_case.UserUseCase
import kotlinx.coroutines.launch

class MainViewModel (
    private val userUseCase: UserUseCase,
    private val userPreference: UserPreference
) : ViewModel() {

//    fun getDetailUser(
//        id: String
//    ) = userUseCase.getDetailUser(id)

    fun getUserData() = userPreference.getUser().asLiveData()


    fun signOut() {
        viewModelScope.launch {
            userPreference.logout()
        }
    }
    }
