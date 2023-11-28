package com.example.roadtochamp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.roadtochamp.R

class HomePageActivity : AppCompatActivity() {

    private lateinit var nutritionButton : Button
    private lateinit var workoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        nutritionButton = findViewById(R.id.nutritionButton)


        nutritionButton.setOnClickListener {
            val intent = Intent(this, NutritionHomeActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}