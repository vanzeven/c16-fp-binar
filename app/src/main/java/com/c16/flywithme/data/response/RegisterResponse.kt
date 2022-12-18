package com.c16.flywithme.data.response


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val `data`: NewUser,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)

data class NewUser(
    @SerializedName("address")
    val address: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("NIK")
    val nIK: Long,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("roleId")
    val roleId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)

data class Data(
    @SerializedName("newUser")
    val newUser: NewUser
)