package com.c16.flywithme.data.response

import com.google.gson.annotations.SerializedName
import java.sql.Struct

data class UserDetailResponse(

	@SerializedName("error")
	val error: Boolean,

	@SerializedName("message")
	val message: String,

	@SerializedName("user")
	val user: ArrayList<UserItem>
) {

	data class UserItem(

		@SerializedName("address")
		val address: String,

		@SerializedName("createdAt")
		val createdAt: String,

		@SerializedName("dateOfBirth")
		val dateOfBirth: String,

		@SerializedName("email")
		val email: String,

		@SerializedName("firstName")
		val firstName: String,

		@SerializedName("gender")
		val gender: String,

		@SerializedName("id")
		val id: Int,

		@SerializedName("image")
		val image: Any,

		@SerializedName("lastName")
		val lastName: String,

		@SerializedName("NIK")
		val NIK: String,

		@SerializedName("password")
		val password: String,

		@SerializedName("phoneNumber")
		val phoneNumber: String,

		@SerializedName("roleId")
		val roleId: String,

		@SerializedName("updatedAt")
		val updatedAt: String

	)
}
