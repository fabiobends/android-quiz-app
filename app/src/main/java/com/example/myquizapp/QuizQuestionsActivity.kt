package com.example.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

  private var progressBar: ProgressBar? = null
  private var progressFraction: TextView? = null
  private var image: ImageView? = null
  private var optionOne: TextView? = null
  private var optionTwo: TextView? = null
  private var optionThree: TextView? = null
  private var optionFour: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quiz_questions)

    progressBar = findViewById(R.id.progress_bar)
    progressFraction = findViewById(R.id.progress_fraction)
    image = findViewById(R.id.flag_image)
    optionOne = findViewById(R.id.option_one)
    optionTwo = findViewById(R.id.option_two)
    optionThree = findViewById(R.id.option_three)
    optionFour = findViewById(R.id.option_four)

    val questionsList = Constants.getQuestions()
    Log.i("QuestionsList size", questionsList.size.toString())

    var currentPosition = 0
    val question: Question = questionsList[currentPosition]
    progressBar?.progress = currentPosition + 1
    progressFraction?.text = "${currentPosition + 1} / ${progressBar?.max}"
    image?.setImageResource(question.image)
    optionOne?.text = question.optionOne
    optionTwo?.text = question.optionTwo
    optionThree?.text = question.optionThree
    optionFour?.text = question.optionFour
  }
}