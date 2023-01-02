package com.c16.flywithme.data.model.byid

import com.google.gson.annotations.SerializedName

data class DataById(
    @SerializedName("airLine")
    val airLine: String?,
    @SerializedName("AirPort")
    val airPort: AirPort?,
    @SerializedName("airPortId")
    val airPortId: Int?,
    @SerializedName("arrivalDate")
    val arrivalDate: String?,
    @SerializedName("arrivalTime")
    val arrivalTime: String?,
    @SerializedName("capasity")
    val capasity: Int?,
    @SerializedName("ClassPrice")
    val classPrice: Int?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("depatureDate")
    val depatureDate: String?,
    @SerializedName("depatureTime")
    val depatureTime: String?,
    @SerializedName("destinationId")
    val destinationId: Int?,
    @SerializedName("flightNumber")
    val flightNumber: String?,
    @SerializedName("from")
    val from: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("Seats")
    val seats: List<Any>,
    @SerializedName("to")
    val to: String?,
    @SerializedName("typeOfClass")
    val typeOfClass: Any?,
    @SerializedName("typeOfFlight")
    val typeOfFlight: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)
