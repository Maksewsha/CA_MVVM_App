package com.maksewsha.camvvm_app.data.repository

import com.maksewsha.camvvm_app.data.storage.User
import com.maksewsha.camvvm_app.data.storage.UserStorage
import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.models.UserName
import com.maksewsha.camvvm_app.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserName): Boolean {
        return userStorage.save(mapToStorage(saveParam))
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(user.firstName, user.lastName)
    }

    private fun mapToStorage(user: SaveUserName): User{
        return User(user.name, "")
    }
}