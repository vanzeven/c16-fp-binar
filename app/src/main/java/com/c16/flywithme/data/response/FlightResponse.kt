package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName

data class FlightResponse(

	@field:SerializedName("data")
	val data: List<FlightsItem>,

	@field:SerializedName("meesage")
	val meesage: String,

	@field:SerializedName("status")
	val status: String
)
