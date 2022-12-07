package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("loginResult")
    val data: LoginResult,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class LoginResult(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,
)
