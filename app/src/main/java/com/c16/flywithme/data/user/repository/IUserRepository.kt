package com.c16.flywithme.data.user.repository

import androidx.lifecycle.LiveData
import com.c16.flywithme.data.response.LoginResponse
import com.c16.flywithme.data.user.model.UserDetail
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.result.Result

interface IUserRepository {
    fun loginUser(email: String, pass: String): LiveData<Result<LoginResponse>>


    fun getDetailUser(
        id: String
    ): LiveData<Result<UserDetail>>
}