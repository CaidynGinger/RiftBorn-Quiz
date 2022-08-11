package com.example.riftbornquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.riftbornquiz.databinding.ActivityQuizQuestionsBinding
import com.example.riftbornquiz.modles.Constants.getAllQuestions

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_quiz_questions)

        var questions = getAllQuestions()

        binding.tvQuestionText.text = questions[0].questionText

    }
}