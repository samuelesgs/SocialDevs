package com.saltwortdevs.socialdevs.domain.repository

interface AuthRepository {
    fun doLogin(user : String, password : String) : Boolean
}