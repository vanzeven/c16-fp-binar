package com.c16.flywithme.data.model.byid


import com.google.gson.annotations.SerializedName

data class AirPort(
    @SerializedName("code")
    val code: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)