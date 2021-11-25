package com.maksewsha.camvvm_app.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.camvvm_app.data.repository.UserRepositoryImpl
import com.maksewsha.camvvm_app.data.storage.SharedPrefUserStorage
import com.maksewsha.camvvm_app.domain.usecase.GetUserNameUseCase
import com.maksewsha.camvvm_app.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}