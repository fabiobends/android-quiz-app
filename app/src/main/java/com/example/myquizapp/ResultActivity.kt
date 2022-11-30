package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    val name: TextView = findViewById(R.id.user_name)
    val score: TextView = findViewById(R.id.score)
    val finishButton: Button = findViewById(R.id.finish_button)

    name.text = intent.getStringExtra(Constants.USER_NAME)
    score.text = getScore()

    finishButton.setOnClickListener {
      startActivity(Intent(this, MainActivity::class.java))
    }
  }

  private fun getScore(): String {
    val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
    val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
    return "You score is $correctAnswers out of $totalQuestions"
  }
}