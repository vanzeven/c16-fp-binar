package com.c16.flywithme.data.remote

import com.c16.flywithme.data.request.LoginRequest
import com.c16.flywithme.data.response.LoginResponse
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


    @GET("user/{id}")
    suspend fun detailUser(
        @Field("id") id: String
    ): Response<UserDetailResponse>
}