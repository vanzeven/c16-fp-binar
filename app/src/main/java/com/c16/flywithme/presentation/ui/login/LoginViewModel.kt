package com.c16.flywithme.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.user.model.UserModel
import com.c16.flywithme.data.user.preference.UserPreference
import com.c16.flywithme.data.user.use_case.UserUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userUseCase: UserUseCase,
    private val userPreference: UserPreference
) : ViewModel() {

    fun loginUser(email: String, pass: String) = userUseCase.loginUser(email, pass)

    fun saveUser(userLogin: UserLogin) {
        viewModelScope.launch {
            val data = UserModel(
                userLogin.localId,
                userLogin.email,
                userLogin.password,
                true
            )
            userPreference.saveUser(data)
        }
    }
}