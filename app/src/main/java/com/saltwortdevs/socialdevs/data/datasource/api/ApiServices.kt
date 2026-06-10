package com.saltwortdevs.socialdevs.data.datasource.api

import com.saltwortdevs.socialdevs.data.response.UserResponse
import retrofit2.http.GET


interface ApiServices {
    @GET("doLogin.json")
    suspend fun doLogin() : List<UserResponse>
}