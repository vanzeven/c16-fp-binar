package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName

data class AirportResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("meesage")
	val meesage: String,

	@field:SerializedName("status")
	val status: String
)

data class FlightsItem(

	@field:SerializedName("ClassPrice")
	val classPrice: Int,

	@field:SerializedName("airPortId")
	val airPortId: Int,

	@field:SerializedName("destinationId")
	val destinationId: Int,

	@field:SerializedName("airLine")
	val airLine: String,

	@field:SerializedName("flightNumber")
	val flightNumber: String,

	@field:SerializedName("arrivalDate")
	val arrivalDate: String,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("arrivalTime")
	val arrivalTime: String,

	@field:SerializedName("capasity")
	val capasity: Int,

	@field:SerializedName("from")
	val from: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("to")
	val to: String,

	@field:SerializedName("typeOfClass")
	val typeOfClass: String,

	@field:SerializedName("depatureDate")
	val depatureDate: String,

	@field:SerializedName("depatureTime")
	val depatureTime: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)

data class DataItem(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("Flights")
	val flights: List<FlightsItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
