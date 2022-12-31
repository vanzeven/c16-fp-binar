package com.c16.flywithme.data.user.model

data class UserModel(
    val userId: Int,
    val email: String,
    val isLogin: Boolean,
    val token: String
)