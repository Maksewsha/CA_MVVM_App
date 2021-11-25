package com.maksewsha.camvvm_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.camvvm_app.R
import com.maksewsha.camvvm_app.data.repository.UserRepositoryImpl
import com.maksewsha.camvvm_app.data.storage.SharedPrefUserStorage
import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.usecase.GetUserNameUseCase
import com.maksewsha.camvvm_app.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        viewModel.resultLive.observe(this, {
            dataTextView.text = it
        })

        sendButton.setOnClickListener{
            viewModel.save(dataEditView.text.toString())
        }

        receiveButton.setOnClickListener{
            viewModel.receive()
        }
    }
}