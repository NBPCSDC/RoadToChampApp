package com.example.roadtochamp.dataManager

import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.workout.Workout

interface IDataSource {
    fun getWorkouts(): List<Workout>
    fun getAliments():List<Aliment>
    fun setWorkouts(workouts : List<Workout>)
    fun setAliments(aliments : List<Aliment>)
}