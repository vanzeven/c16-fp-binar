package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName

data class BaseAuthResponse<T, E>(
    @field:SerializedName("success")
    val succes: Boolean,
    @field:SerializedName("data")
    val data: T,
    @field:SerializedName("errors")
    val errors: E,
)