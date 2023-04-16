package com.hemant.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    private var questionText: TextView? = null
    private var flagImage: ImageView? = null

    private var optOne: TextView? = null
    private var optTwo: TextView? = null
    private var optThree: TextView? = null
    private var optFour: TextView? = null

    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)
        questionText = findViewById(R.id.QuestionText)
        flagImage = findViewById(R.id.FlagImage)
        optOne = findViewById(R.id.OptOne)
        optThree = findViewById(R.id.OptThree)
        optTwo = findViewById(R.id.OptTwo)
        optFour = findViewById(R.id.OptFour)

        optOne?.setOnClickListener(this)
        optTwo?.setOnClickListener(this)
        optThree?.setOnClickListener(this)
        optFour?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.SubmitBtn)
        btnSubmit?.setOnClickListener(this)


        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        flagImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        progressText?.text = "$mCurrentPosition / ${progressBar?.max}"
        questionText?.text = question.question
        optOne?.text = question.opt1
        optTwo?.text = question.opt2
        optThree?.text = question.opt3
        optFour?.text = question.opt4

        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        optOne?.let {
            options.add(0, it)
        }
        optTwo?.let {
            options.add(0, it)
        }
        optThree?.let {
            options.add(0, it)
        }
        optFour?.let {
            options.add(0, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.OptOne -> {
                optOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.OptTwo -> {
                optTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.OptThree -> {
                optThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.OptFour -> {
                optFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.SubmitBtn -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctOpt != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctOpt, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optOne?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                optTwo?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optThree?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                optFour?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}