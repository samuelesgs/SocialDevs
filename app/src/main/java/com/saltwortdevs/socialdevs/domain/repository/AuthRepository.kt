package com.saltwortdevs.socialdevs.domain.repository

import com.saltwortdevs.socialdevs.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user : String, password : String) : UserEntity
}