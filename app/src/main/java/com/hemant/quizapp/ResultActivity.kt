package com.hemant.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username: TextView = findViewById(R.id.username_textview)
        val score:TextView = findViewById(R.id.tvScore)
        val finishbtn:Button = findViewById(R.id.finish_btn)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        username.text = intent.getStringExtra(Constants.USER_NAME)
        score.text = "Your Score is ${correctAnswers} out of ${totalQuestion}"

        finishbtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}