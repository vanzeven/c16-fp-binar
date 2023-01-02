package com.c16.flywithme.data.response

import com.c16.flywithme.data.model.byid.DataById
import com.google.gson.annotations.SerializedName

data class FlightByIdResponse(
    @SerializedName("data")
    val `data`: DataById?,
    @SerializedName("meesage")
    val meesage: String,
    @SerializedName("status")
    val status: String
)
