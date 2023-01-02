package com.c16.flywithme.data.remote

import com.c16.flywithme.data.request.HistoriesRequest
import com.c16.flywithme.data.request.LoginRequest
import com.c16.flywithme.data.response.HistoryResponse
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


    @GET("api/users/findById/{id}")
    fun detailUser(
        @Path("id") id: String
    ): Call<UserDetailResponse>

    @POST("api/Histories")
    fun histories(
        @Body historiesRequest: HistoriesRequest
    ): Call<HistoryResponse>
}