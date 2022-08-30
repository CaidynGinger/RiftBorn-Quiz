package com.example.riftbornquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.riftbornquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
private const val TAG = "MyActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btnStart.setOnClickListener {
            val username = binding.etUsername.text

            if (username.toString() == ""){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$username", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, CategoriesActivity::class.java)

                intent.putExtra("Username", "$username")

                startActivity(intent)
                finish() // close home
            }
        }
    }

}