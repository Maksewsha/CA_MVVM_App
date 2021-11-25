package com.maksewsha.camvvm_app.data.repository

import android.content.Context
import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.models.UserName
import com.maksewsha.camvvm_app.domain.repository.UserRepository

class UserRepositoryImpl(context: Context) : UserRepository {

    companion object{
        private const val SHARED_PREFS_NAME = "shared_prefs_name"
        private const val KEY_FIRST_NAME = "firstName"
        private const val KEY_LAST_NAME = "lastName"
    }

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserName): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        return UserName("${sharedPreferences.getString(KEY_FIRST_NAME, "")}", "${sharedPreferences.getString(
            KEY_LAST_NAME, "Default last name")}")
    }
}