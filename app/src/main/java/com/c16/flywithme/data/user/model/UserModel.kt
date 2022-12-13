package com.c16.flywithme.data.user.model

data class UserModel(
    val localid: Int,
    val email: String,
    val password: String,
    val isLogin: Boolean
)