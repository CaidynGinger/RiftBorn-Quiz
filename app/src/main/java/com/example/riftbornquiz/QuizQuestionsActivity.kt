package com.example.riftbornquiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.riftbornquiz.databinding.ActivityQuizQuestionsBinding
import com.example.riftbornquiz.modles.Constants.getAllQuestions
import com.example.riftbornquiz.modles.Question

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding


    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question> ? = null
    private var mSelectedOptionPosition : Int = 0
    private var mTotalScore : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_categories)
        this.binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = getAllQuestions()
        setQuestionView()

//        setContentView(R.layout.activity_quiz_questions)
        val profileName = intent.getStringExtra("Username")
        val category = intent.getStringExtra("Selection")
        fun resetQuestions() {
            var options = ArrayList<TextView>()
            options.add(0, binding.tvOptionOne)
            options.add(1, binding.tvOptionTwo)
            options.add(2, binding.tvOptionThree)
            options.add(3, binding.tvOptionFour)
            for (option in options){
                option.setTextColor(Color.parseColor("#7a8089"))
                option.setBackgroundColor(Color.parseColor("#00ffffff"))
            }
            mSelectedOptionPosition = 0
        }
        resetQuestions()

        binding.tvOptionOne.setOnClickListener{
            resetQuestions()
            this.binding.tvOptionOne.setTextColor(Color.parseColor("#ffffff"))
            this.binding.tvOptionOne.setBackgroundColor(Color.parseColor("#3F51B5"))
            mSelectedOptionPosition = 1
        }
        binding.tvOptionTwo.setOnClickListener{
            resetQuestions()
            this.binding.tvOptionTwo.setTextColor(Color.parseColor("#ffffff"))
            this.binding.tvOptionTwo.setBackgroundColor(Color.parseColor("#3F51B5"))
            mSelectedOptionPosition = 2
        }
        binding.tvOptionThree.setOnClickListener{
            resetQuestions()
            this.binding.tvOptionThree.setTextColor(Color.parseColor("#ffffff"))
            this.binding.tvOptionThree.setBackgroundColor(Color.parseColor("#3F51B5"))
            mSelectedOptionPosition = 3
        }
        binding.tvOptionFour.setOnClickListener{
            resetQuestions()
            this.binding.tvOptionFour.setTextColor(Color.parseColor("#ffffff"))
            this.binding.tvOptionFour.setBackgroundColor(Color.parseColor("#3F51B5"))
            mSelectedOptionPosition = 4
        }

        binding.btnSubmit.setOnClickListener {
            if (mSelectedOptionPosition === mQuestionsList!![mCurrentPosition-1].correctOption){
                mTotalScore ++
            }

            mCurrentPosition ++
            resetQuestions()
            if (mCurrentPosition > 5){
                val intent = Intent(this@QuizQuestionsActivity, EndQuestionsActivity::class.java)

                intent.putExtra("Username", "$profileName")
                intent.putExtra("TotalScore", "$mTotalScore")
                intent.putExtra("category", "$category")

                startActivity(intent)
                finish() // close home
            } else {
                setQuestionView()
            }
        }
//        Log.i("Questions Size", "${questionsList.size}")
//        Log.i("Username", "$profileName")
//        Log.i("Category", "$category")

    }

    private fun setQuestionView() {

        val question = mQuestionsList!![mCurrentPosition-1]

        this.binding.progressBar.progress = mCurrentPosition
        this.binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        this.binding.tcQuestion.text = question!!.questionText
        this.binding.ivQuestionImage.setImageResource(question.image)

        this.binding.tvOptionOne.text = " A. ${question.optionOne}"
        this.binding.tvOptionTwo.text = " B. ${question.optionTwo}"
        this.binding.tvOptionThree.text = " C. ${question.optionThree}"
        this.binding.tvOptionFour.text = " D. ${question.optionFour}"
    }

}