package com.maksewsha.camvvm_app.data.storage

import com.maksewsha.camvvm_app.domain.models.SaveUserName

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}