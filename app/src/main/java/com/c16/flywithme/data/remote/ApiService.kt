package com.c16.flywithme.data.remote

import com.c16.flywithme.data.response.LoginResponse
import com.c16.flywithme.data.response.UserDetailResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("api/login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
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

    //endpoint : BASE_URL + Value GET (https://flywithme-be.up.railway.app/user/{id}
    @GET("user/{id}")
    suspend fun detailUser(
        @Field("id") id: String
    ): Response<UserDetailResponse>
}