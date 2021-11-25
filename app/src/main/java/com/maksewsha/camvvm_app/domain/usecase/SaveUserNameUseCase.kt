package com.maksewsha.camvvm_app.domain.usecase

import com.maksewsha.camvvm_app.domain.models.SaveUserName

class SaveUserNameUseCase {

    fun execute(param: SaveUserName): Boolean = param.name.isNotEmpty()
}