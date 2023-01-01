package com.c16.flywithme.presentation.ui.user.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.c16.flywithme.data.response.LoginResponse
import com.c16.flywithme.data.user.use_case.UserUseCase
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.user.model.UserModel
import com.c16.flywithme.data.user.preference.UserPreference
import kotlinx.coroutines.launch


class LoginViewModel(
    private val userUseCase: UserUseCase,
    private val userPreference: UserPreference
) : ViewModel() {

    fun loginUser(email: String, pass: String) = userUseCase.loginUser(email, pass)

    fun saveUser(userLogin: LoginResponse) {
        viewModelScope.launch {
            val data = UserModel(
                userLogin.data.id,
                userLogin.data.email,
                userLogin.token,
                true
            )
            userPreference.saveUser(data)
        }
    }

    fun getToken() = userPreference.getToken().asLiveData()

    fun getIsLogin() = userPreference.getIsLogin().asLiveData()
}