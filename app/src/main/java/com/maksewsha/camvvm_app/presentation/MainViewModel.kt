package com.maksewsha.camvvm_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.camvvm_app.data.repository.UserRepositoryImpl
import com.maksewsha.camvvm_app.data.storage.SharedPrefUserStorage
import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.usecase.GetUserNameUseCase
import com.maksewsha.camvvm_app.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    var resultLive = MutableLiveData<String>()

    fun save(text: String) {
        val resultData = saveUserNameUseCase.execute(SaveUserName(text))
        resultLive.value = "Save result = $resultData"
    }

    fun receive() {
        val userName = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

}