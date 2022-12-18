package com.c16.flywithme.presentation.ui.user.register

import androidx.lifecycle.ViewModel
import com.c16.flywithme.data.user.use_case.UserUseCase

class RegisterViewModel(private val userUseCase: UserUseCase) : ViewModel() {

    fun registerUser(
        email: String,
        firstName: String,
        lastName: String,
        nIK: Long,
        password: String,
        phoneNumber: String,
    ) = userUseCase.registerUser(email, firstName, lastName, nIK, password, phoneNumber)

//    fun registerUser(
//        email: String,
//        pass: String,
//        cpass: String,
//        fname: String,
//        lname: String,
//        nik: String,
//        phone: String,
//    ) = userUseCase.registerUser(email, pass, cpass, fname, lname, nik, phone)
}