package com.c16.flywithme.data.remote

import com.c16.flywithme.data.request.LoginRequest
import com.c16.flywithme.data.response.*
import retrofit2.*
import retrofit2.http.*

interface ApiService {

//    @FormUrlEncoded
    @POST("api/login")
    suspend fun loginUser(
    @Body loginRequest: LoginRequest,
//        @Field("email") email: String,
//        @Field("password") password: String
    ): Response<LoginResponse>

//    @FormUrlEncoded
//    @POST("api/register")
//    suspend fun registerUser(
//        @Field("email") email: String,
//        @Field("password") password: String,
//        @Field("password_confirmation") password_confirmation: String,
//        @Field("firstName") firstname: String,
//        @Field("lastName") lastname: String,
////        @Field("gender") gender: String,
//        @Field("NIK") nik: String,
//        @Field("phoneNumber") phone: String,
//        @Field("address") address: String,
//    ): Response<RegisterResponse>

    @GET("user/{id}")
    suspend fun detailUser(
        @Field("id") id: String
    ): Response<UserDetailResponse>

    @GET("api/airports/findAll")
    fun getAllAirports(): Call<AirportResponse>

    @GET("api/flights/findAll")
    fun getAllFlights(): Call<FlightResponse>

    @FormUrlEncoded
    @POST("api/bookings/add")
    fun addBooking(
        @Field("name") name: String,
        @Field("age") age: Int,
        @Field("NIK") nik: Long,
        @Field("phoneNumber") phoneNumber: String,
        @Field("seatNumber") seatNumber: String?,
        @Field("price") price: Int,
        @Field("flightId") flightId: Int,
        @Field("userId") userId: Int
    ): Call<AddBookingResponse>

}