package com.maksewsha.camvvm_app.data.storage

import android.content.Context

class SharedPrefUserStorage(context: Context) : UserStorage {

    companion object {
        private const val SHARED_PREFS_NAME = "shared_prefs_name"
        private const val KEY_FIRST_NAME = "firstName"
        private const val KEY_LAST_NAME = "lastName"
    }

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get() = User(
        "${sharedPreferences.getString(KEY_FIRST_NAME, "")}",
        "${sharedPreferences.getString(KEY_LAST_NAME, "Default last name")}"
    )
}