package com.saltwortdevs.socialdevs.data.repository

import android.util.Log
import com.saltwortdevs.socialdevs.data.datasource.api.ApiServices
import com.saltwortdevs.socialdevs.data.response.UserResponse
import com.saltwortdevs.socialdevs.data.response.toDomain
import com.saltwortdevs.socialdevs.domain.entity.UserEntity
import com.saltwortdevs.socialdevs.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(val api : ApiServices)  : AuthRepository{
    override suspend fun doLogin(user: String, password: String): List<UserEntity> {
        val response = try { api.doLogin() } catch (e : Exception) {
            Log.i("ERROR_LOGIN_DO", "doLogin: ${e}")
            listOf()
        }

        return response.map {it.toDomain()}
        /*val userResponse = UserResponse("", "", "", 10, listOf(""),0)

        return userResponse.toDomain()*/
    }
}