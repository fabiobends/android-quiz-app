package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

  private var progressBar: ProgressBar? = null
  private var progressFraction: TextView? = null
  private var image: ImageView? = null
  private var optionOne: TextView? = null
  private var optionTwo: TextView? = null
  private var optionThree: TextView? = null
  private var optionFour: TextView? = null
  private var submitButton: Button? = null

  private var currentPosition: Int = 1
  private var questionsList: ArrayList<Question>? = null
  private var selectedOptionPosition: Int = Int.MAX_VALUE
  private var userName: String? = null
  private var correctAnswers: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quiz_questions)

    userName = intent.getStringExtra(Constants.USER_NAME)

    progressBar = findViewById(R.id.progress_bar)
    progressFraction = findViewById(R.id.progress_fraction)
    image = findViewById(R.id.flag_image)
    optionOne = findViewById(R.id.option_one)
    optionTwo = findViewById(R.id.option_two)
    optionThree = findViewById(R.id.option_three)
    optionFour = findViewById(R.id.option_four)
    submitButton = findViewById(R.id.submit_button)

    questionsList = Constants.getQuestions()
    setQuestion()

    optionOne?.setOnClickListener(this)
    optionTwo?.setOnClickListener(this)
    optionThree?.setOnClickListener(this)
    optionFour?.setOnClickListener(this)
    submitButton?.setOnClickListener(this)
  }

  private fun setQuestion() {
    defaultOptionsView()
    val question: Question = questionsList!![currentPosition - 1]
    progressBar?.progress = currentPosition
    progressFraction?.text = "$currentPosition / ${progressBar?.max}"
    image?.setImageResource(question.image)
    optionOne?.text = question.optionOne
    optionTwo?.text = question.optionTwo
    optionThree?.text = question.optionThree
    optionFour?.text = question.optionFour

    if (currentPosition == questionsList!!.size) {
      submitButton?.text = "Finish"
    } else {
      submitButton?.text = "Go to the next"
    }

  }

  override fun onClick(view: View?) {
    when (view?.id) {
      R.id.option_one -> {
        optionOne?.let {
          selectedOptionView(it, 0)
        }
      }
      R.id.option_two -> {
        optionTwo?.let {
          selectedOptionView(it, 1)
        }
      }
      R.id.option_three -> {
        optionThree?.let {
          selectedOptionView(it, 2)
        }
      }
      R.id.option_four -> {
        optionFour?.let {
          selectedOptionView(it, 3)
        }
      }
      R.id.submit_button -> {
        if (selectedOptionPosition == Int.MAX_VALUE) {
          currentPosition++
          when {
            currentPosition <= questionsList!!.size -> {
              setQuestion()
            }
            else -> {
              val intent = Intent(this, ResultActivity::class.java)
              intent.putExtra(Constants.USER_NAME, userName)
              intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList?.size)
              intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
              startActivity(intent)
              finish()
            }
          }
        } else {
          val question = questionsList?.get(currentPosition - 1)
          if (question!!.correctAnswer != selectedOptionPosition) {
            answerView(selectedOptionPosition, R.drawable.wrong_option_bg)
          } else {
            correctAnswers++
          }

          answerView(question.correctAnswer, R.drawable.correct_option_bg)
          selectedOptionPosition = Int.MAX_VALUE
        }

      }

    }

  }

  private fun defaultOptionsView() {
    val options = ArrayList<TextView>()
    optionOne?.let {
      options.add(0, it)
    }
    optionTwo?.let {
      options.add(1, it)
    }
    optionThree?.let {
      options.add(2, it)
    }
    optionFour?.let {
      options.add(3, it)
    }

    for (option in options) {
      option.setTextColor(Color.parseColor("#363a43"))
      option.typeface = Typeface.DEFAULT
      option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

    }
  }

  private fun selectedOptionView(textView: TextView, selectedOptionNumber: Int) {
    defaultOptionsView()
    selectedOptionPosition = selectedOptionNumber
    textView.setTextColor(Color.parseColor("#7a8089"))
    textView.setTypeface(textView.typeface, Typeface.BOLD)
    textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
  }

  private fun answerView(answer: Int, drawableView: Int) {
    when (answer) {
      0 -> {
        optionOne?.background = ContextCompat.getDrawable(
          this,
          drawableView
        )
      }
      1 -> {
        optionTwo?.background = ContextCompat.getDrawable(
          this,
          drawableView
        )
      }
      2 -> {
        optionThree?.background = ContextCompat.getDrawable(
          this,
          drawableView
        )
      }
      3 -> {
        optionFour?.background = ContextCompat.getDrawable(
          this,
          drawableView
        )
      }
    }
  }

}