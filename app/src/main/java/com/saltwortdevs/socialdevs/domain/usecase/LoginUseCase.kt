package com.saltwortdevs.socialdevs.domain.usecase

import com.saltwortdevs.socialdevs.domain.entity.UserEntity
import com.saltwortdevs.socialdevs.domain.repository.AuthRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(user: String, password: String): UserEntity? {
        if (user.contains("@hotmail.com")) return null
        val response = authRepository.doLogin(user, password)

        return response.randomOrNull()
    }
}