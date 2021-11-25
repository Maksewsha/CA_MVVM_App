package com.maksewsha.camvvm_app.domain.usecase

import com.maksewsha.camvvm_app.domain.models.UserName
import com.maksewsha.camvvm_app.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() = userRepository.getName()
}