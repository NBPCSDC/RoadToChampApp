package com.example.roadtochamp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.R
import com.example.roadtochamp.injection.ViewModelFactory
import com.example.roadtochamp.model.LocalWorkoutRepository

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)

        val workoutViewModel = ViewModelProvider(this,ViewModelFactory)[WorkoutViewModel::class.java]

        workoutViewModel.currentWorkout.observe(this) {
            text.text = workoutViewModel.currentWorkout.value.toString()
            println("CA A CHANGE BRO")
        }

        button.setOnClickListener {
            workoutViewModel.changeWorkout()
        }
    }
}