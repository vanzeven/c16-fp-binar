package com.c16.flywithme.data.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("googleId")
    val googleId: Any? = null,
    @SerializedName("Histories")
    val histories: List<Any?>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Any? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("NIK")
    val nIK: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("phoneNumber")
    val phoneNumber: String? = null,
    @SerializedName("roleId")
    val roleId: String? = null,
    @SerializedName("Transactions")
    val transactions: List<Any?>? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null,
    @SerializedName("verified")
    val verified: Any? = null
)