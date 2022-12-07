package com.c16.flywithme.data.user.repository

import androidx.lifecycle.LiveData
import com.c16.flywithme.data.user.model.UserDetail
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.user.model.UserRegister
import com.c16.flywithme.data.result.Result

interface IUserRepository {
    fun loginUser(email: String, pass: String): LiveData<Result<UserLogin>>

    fun registerUser(
        email: String,
        pass: String,
        cpass: String,
        fname: String,
        lname: String,
        nik: String,
        phone: String
    ): LiveData<Result<UserRegister>>

    fun getDetailUser(
        id: String
    ): LiveData<Result<UserDetail>>
}