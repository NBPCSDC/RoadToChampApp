package com.example.roadtochamp.model

interface WorkoutRepository{

    fun getWorkouts(): List<Workout>
}