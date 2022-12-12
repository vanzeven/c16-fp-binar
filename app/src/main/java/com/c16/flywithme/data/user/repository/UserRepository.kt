package com.c16.flywithme.data.user.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.c16.flywithme.data.remote.ApiService
import com.c16.flywithme.data.request.LoginRequest
import com.c16.flywithme.data.result.Result
import com.c16.flywithme.data.user.model.UserDetail
import com.c16.flywithme.data.user.model.UserLogin

class UserRepository(
    private val apiService: ApiService
) : IUserRepository {

    override fun loginUser(email: String, pass: String): LiveData<Result<UserLogin>> = liveData {
        emit(Result.Loading)

        try {
            val response = apiService.loginUser(LoginRequest(email, pass))

            if (response.body()?.status == false) {
                val data = UserLogin(
                    response.body()?.`data`?.email!!,
                    response.body()?.`data`?.password!!,
                )
                emit(Result.Success(data))
            } else if (response.body()?.status == true) {
                emit(Result.Error("Email atau Password anda salah"))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

//    override fun registerUser(
//        email: String,
//        pass: String,
//        cpass: String,
//        fname: String,
//        lname: String,
//        nik: String,
//        phone: String
//    ): LiveData<Result<UserRegister>> = liveData {
//        emit(Result.Loading)
//
//        try {
//            val response = apiService.registerUser(email, pass, cpass, fname, lname, nik, phone, "user")
//            if (response.body()?.error == false) {
//                val data = UserRegister(response.body()?.message!!)
//                emit(Result.Success(data))
//            } else {
//                emit(Result.Error("Email anda sudah terdaftar"))
//            }
//        } catch (e: Exception) {
//            emit(Result.Error(e.message.toString()))
//        }
//    }

    override fun getDetailUser(
        id: String
    ): LiveData<Result<UserDetail>> = liveData {
        emit(Result.Loading)

        try {
            val response = apiService.detailUser(id)

            if (response.body()?.error == false) {
                val data = UserDetail(

                    response.body()?.user?.get(0)?.address!!,
                    response.body()?.user?.get(0)?.createdAt!!,
                    response.body()?.user?.get(0)?.dateOfBirth!!,
                    response.body()?.user?.get(0)?.email!!,
                    response.body()?.user?.get(0)?.firstName!!,
                    response.body()?.user?.get(0)?.gender!!,
                    response.body()?.user?.get(0)?.id!!,
                    response.body()?.user?.get(0)?.image!!,
                    response.body()?.user?.get(0)?.lastName!!,
                    response.body()?.user?.get(0)?.NIK!!,
                    response.body()?.user?.get(0)?.password!!,
                    response.body()?.user?.get(0)?.phoneNumber!!,
                    response.body()?.user?.get(0)?.roleId!!,
                    response.body()?.user?.get(0)?.updatedAt!!
                )
                emit(Result.Success(data))
            } else {
                emit(Result.Error("ID tidak ditemukan "))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

}