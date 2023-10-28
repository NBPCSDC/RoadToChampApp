package com.example.roadtochamp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.NutritionHomeActivity
import com.example.roadtochamp.R
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.injection.ViewModelFactory
import com.example.roadtochamp.repository.AppRepository
import com.example.roadtochamp.view.viewModel.AlimentViewModel
import com.example.roadtochamp.view.viewModel.DayConsoViewModel
import com.example.roadtochamp.view.viewModel.WorkoutViewModel

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