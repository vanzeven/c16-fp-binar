package com.c16.flywithme.data.remote

import com.c16.flywithme.data.request.LoginRequest
import com.c16.flywithme.data.request.RegisterRequest
import com.c16.flywithme.data.response.LoginResponse
import com.c16.flywithme.data.response.RegisterResponse
import com.c16.flywithme.data.response.UserDetailResponse
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

    @POST("api/register")
    suspend fun registerUser(
        @Body registerRequest: RegisterRequest,
    ) : Response<RegisterResponse>

    @GET("user/{id}")
    suspend fun detailUser(
        @Field("id") id: String
    ): Response<UserDetailResponse>
}