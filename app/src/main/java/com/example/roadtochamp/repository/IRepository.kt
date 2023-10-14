package com.example.roadtochamp.repository

import androidx.lifecycle.LiveData
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.workout.Workout

interface IRepository{
    fun getWorkouts(): LiveData<List<Workout>>

    fun getAliments(): LiveData<List<Aliment>>

    fun saveWorkouts(workouts : List<Workout>)

    fun saveAliments(aliments : List<Aliment>)

}