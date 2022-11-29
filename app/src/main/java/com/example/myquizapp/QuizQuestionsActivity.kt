package com.example.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
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
  private var selectedOptionPosition: Int = 0

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
        // TODO
        Log.i("test", selectedOptionPosition.toString())
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

}