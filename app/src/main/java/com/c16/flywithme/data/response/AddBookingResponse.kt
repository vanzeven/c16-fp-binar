package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName

data class AddBookingResponse(

	@field:SerializedName("newBooking")
	val newBooking: NewBooking,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class NewBooking(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("price")
	val price: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
