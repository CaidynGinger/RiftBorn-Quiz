package com.example.riftbornquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.riftbornquiz.databinding.ActivityCategoriesBinding
import com.example.riftbornquiz.databinding.ActivityQuizQuestionsBinding

class CategoriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileName = intent.getStringExtra("Username")
        binding.etUsernamePlacement.text = profileName
        binding.btnChemistry.setOnClickListener{
            val intent = Intent(this@CategoriesActivity, QuizQuestionsActivity::class.java)

            intent.putExtra("Selection", "Chemistry")
            intent.putExtra("Username", "$profileName")

            startActivity(intent)
        }

//        val intent = Intent(this@MainActivity, CategoriesActivity::class.java)
//
//        intent.putExtra("Username", "$username")
//
//        startActivity(intent)
    }
}