package com.maksewsha.camvvm_app.domain.repository

import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserName): Boolean

    fun getName(): UserName
}