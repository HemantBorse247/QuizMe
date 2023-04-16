package com.hemant.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn: Button = findViewById(R.id.StartBtn)
        val nameInput: EditText = findViewById(R.id.nameInput)
        startBtn.setOnClickListener {
            if (nameInput.text.isEmpty() || nameInput.text.replace("\\s".toRegex(), "") == "") {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME, nameInput.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }


}