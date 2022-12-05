package com.c16.flywithme.di

import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.user.use_case.UserInteract
import com.c16.flywithme.data.user.use_case.UserUseCase
import com.c16.flywithme.data.user.repository.IUserRepository
import com.c16.flywithme.data.user.repository.UserRepository

object Injection {

    private fun provideUserRepository(): IUserRepository {
        val apiConfig = ApiConfig.getApiService()
        return UserRepository(apiConfig)
    }

    fun provideUserUseCase(): UserUseCase {
        val repository = provideUserRepository()
        return UserInteract(repository)
    }

}