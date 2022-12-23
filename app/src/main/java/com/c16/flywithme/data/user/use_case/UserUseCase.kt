package com.c16.flywithme.data.user.use_case

import androidx.lifecycle.LiveData
import com.c16.flywithme.data.user.model.UserDetail
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.result.Result

interface UserUseCase {
    fun loginUser(email: String, pass: String): LiveData<Result<UserLogin>>


//    fun getDetailUser(
//        id: String
//    ): LiveData<Result<UserDetail>>
}