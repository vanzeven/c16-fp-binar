package com.c16.flywithme.data.user.use_case

import androidx.lifecycle.LiveData
import com.c16.flywithme.data.result.Result
import com.c16.flywithme.data.user.model.UserDetail
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.data.user.model.UserRegister
import com.c16.flywithme.data.user.repository.IUserRepository

class UserInteract(private val userRepository: IUserRepository) :
    UserUseCase {

    override fun loginUser(email: String, pass: String): LiveData<Result<UserLogin>> =
        userRepository.loginUser(email, pass)

    override fun registerUser(
        email: String,
        pass: String,
        cpass: String,
        fname: String,
        lname: String,
        nik: String,
        phone: String,
        address: String
    ): LiveData<Result<UserRegister>> =
        userRepository.registerUser(email, pass, cpass, fname, lname, nik, phone, address)

    override fun getDetailUser(id: String): LiveData<Result<UserDetail>> =
        userRepository.getDetailUser(id)


}