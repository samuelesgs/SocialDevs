package com.saltwortdevs.socialdevs.domain.repository

import com.saltwortdevs.socialdevs.domain.entity.UserEntity

interface AuthRepository {
    suspend fun doLogin(user : String, password : String) : List<UserEntity>
}