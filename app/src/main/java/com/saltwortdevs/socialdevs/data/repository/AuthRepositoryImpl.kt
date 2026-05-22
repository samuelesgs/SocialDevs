package com.saltwortdevs.socialdevs.data.repository

import com.saltwortdevs.socialdevs.data.response.UserResponse
import com.saltwortdevs.socialdevs.data.response.toDomain
import com.saltwortdevs.socialdevs.domain.entity.UserEntity
import com.saltwortdevs.socialdevs.domain.repository.AuthRepository

class AuthRepositoryImpl()  : AuthRepository{

    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse = UserResponse("", "", "", 10, listOf(""),0)
        return userResponse.toDomain()
    }
}