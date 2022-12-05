package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName
import java.sql.Struct

data class UserDetailResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("user")
	val user: List<UserItem>
)

data class UserItem(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
    val email: String,

	@field:SerializedName("firstName")
	val firstName: String,

	@field:SerializedName("lastName")
	val lastName: String,

	@field:SerializedName("nik")
	val nik: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("role_id")
	val roleId: String

)
