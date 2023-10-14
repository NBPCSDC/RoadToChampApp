package com.example.roadtochamp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.R
import com.example.roadtochamp.injection.ViewModelFactory

class HomePageActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var buttonVal : Button
    private lateinit var buttonload : Button
    private lateinit var csvText : TextView
    private lateinit var csvFileText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        buttonload = findViewById(R.id.buttonLoad)
        button = findViewById(R.id.button)
        buttonVal = findViewById(R.id.buttonVal)
        csvText = findViewById(R.id.csvData)
        csvFileText = findViewById(R.id.fileName)

        val viewModelFactory = ViewModelFactory(this)

        val workoutViewModel = ViewModelProvider(this,viewModelFactory)[WorkoutViewModel::class.java]
        val alimentViewModel = ViewModelProvider(this,viewModelFactory)[AlimentViewModel::class.java]

        buttonVal.setOnClickListener{
            workoutViewModel.currentWorkout
        }

        buttonload.setOnClickListener {
        }

    }
}