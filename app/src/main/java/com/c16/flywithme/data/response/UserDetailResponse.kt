package com.c16.flywithme.data.response


import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("meesage")
    val meesage: String? = null,
    @SerializedName("status")
    val status: String? = null
)