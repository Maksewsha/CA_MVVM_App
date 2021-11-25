package com.maksewsha.camvvm_app.domain.usecase

import com.maksewsha.camvvm_app.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName{
        return UserName("Aleksa", "Clearness")
    }
}