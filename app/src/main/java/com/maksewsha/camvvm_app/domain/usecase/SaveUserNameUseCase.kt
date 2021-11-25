package com.maksewsha.camvvm_app.domain.usecase

import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {



    fun execute(param: SaveUserName): Boolean{
        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name){
            return true
        }

        return userRepository.saveName(param)
    }
}