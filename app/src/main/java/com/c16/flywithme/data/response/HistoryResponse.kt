package com.c16.flywithme.data.response


import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("orderList")
    val orderList: ArrayList<Order>
)

data class Order(
    @SerializedName("Booking")
    val booking: Booking,
    @SerializedName("bookingId")
    val bookingId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("Flight")
    val flight: Flight,
    @SerializedName("flightId")
    val flightId: Int,
    @SerializedName("historyDate")
    val historyDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("Notifications")
    val notifications: List<Notification>,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
)

data class Booking(
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("Passengers")
    val passengers: List<Passenger>,
    @SerializedName("Seats")
    val seats: List<Seat>,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
)

data class Flight(
    @SerializedName("airLine")
    val airLine: String,
    @SerializedName("airPortId")
    val airPortId: Int,
    @SerializedName("arrivalDate")
    val arrivalDate: String,
    @SerializedName("arrivalTime")
    val arrivalTime: String,
    @SerializedName("capasity")
    val capasity: Int,
    @SerializedName("ClassPrice")
    val classPrice: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("depatureDate")
    val depatureDate: String,
    @SerializedName("depatureTime")
    val depatureTime: String,
    @SerializedName("destinationId")
    val destinationId: Int,
    @SerializedName("flightNumber")
    val flightNumber: String,
    @SerializedName("from")
    val from: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("to")
    val to: String,
    @SerializedName("typeOfClass")
    val typeOfClass: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)

data class Notification(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("historyId")
    val historyId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
)

data class Passenger(
    @SerializedName("age")
    val age: Int,
    @SerializedName("bookingId")
    val bookingId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("NIK")
    val nIK: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)

data class Seat(
    @SerializedName("bookingId")
    val bookingId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("flightId")
    val flightId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("seatNumber")
    val seatNumber: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)