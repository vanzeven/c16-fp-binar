package com.c16.flywithme.data.request


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
//    @SerializedName("address")
//    val address: String?,
//    @SerializedName("dateOfBirth")
//    val dateOfBirth: String?,
//    @SerializedName("email")
    val email: String,
//    @SerializedName("firstName")
    val firstName: String,
//    @SerializedName("gender")
//    val gender: String,
//    @SerializedName("lastName")
    val lastName: String,
//    @SerializedName("NIK")
    val nIK: Long,
//    @SerializedName("password")
    val password: String,
//    @SerializedName("phoneNumber")
    val phoneNumber: String
)