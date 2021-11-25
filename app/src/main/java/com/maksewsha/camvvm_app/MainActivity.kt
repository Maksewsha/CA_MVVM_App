package com.maksewsha.camvvm_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.maksewsha.camvvm_app.domain.models.SaveUserName
import com.maksewsha.camvvm_app.domain.usecase.GetUserNameUseCase
import com.maksewsha.camvvm_app.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener{
            val text = dataEditView.text.toString()
            val result = saveUserNameUseCase.execute(SaveUserName(text))
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener{
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}