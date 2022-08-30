package com.example.riftbornquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.riftbornquiz.databinding.ActivityEndQuestionsBinding
import com.example.riftbornquiz.databinding.ActivityMainBinding
import com.example.riftbornquiz.modles.Constants

class EndQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEndQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_categories)
        binding = ActivityEndQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profileName = intent.getStringExtra("Username")
        val totalScore = intent.getStringExtra("TotalScore")

        binding.tvTextDetails.text = "$profileName here are your results"
        binding.tvScoreDisplay.text = "$totalScore/5"

        var sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
            putString("lastUser", profileName)
            putString("Category", profileName)
            putString("TotalScore", totalScore)
            apply()
        }

        binding.btnBackToCategories.setOnClickListener {

            val intent = Intent(this@EndQuestionsActivity, CategoriesActivity::class.java)

            intent.putExtra("Username", "$profileName")

            startActivity(intent)
            finish() // close home
        }
    }
}