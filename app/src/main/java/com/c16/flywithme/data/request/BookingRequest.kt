package com.c16.flywithme.data.request

import retrofit2.http.Field

data class BookingRequest(
    val name: String,
    val age: Int,
    val nik: Long,
    val phoneNumber: String,
    val seatNumber: String?,
    val price: Int,
    val flightId: Int,
    val userId: Int
)
