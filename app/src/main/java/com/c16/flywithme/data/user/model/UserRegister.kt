package com.c16.flywithme.data.user.model

data class UserRegister(
    val email: String,
    val firstName: String,
    val lastName: String,
    val nIK: Long,
    val password: String,
    val phoneNumber: String
)
