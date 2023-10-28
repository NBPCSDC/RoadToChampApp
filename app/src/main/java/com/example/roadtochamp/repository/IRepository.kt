package com.example.roadtochamp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.model.workout.Workout

interface IRepository{
    fun getWorkouts(): MutableLiveData<List<Workout>>

    fun getAliments(): MutableLiveData<List<Aliment>>

    fun getDayConso(): MutableLiveData<DayConso>
    fun getDayConsoHistory() : MutableLiveData<List<DayConso>>

    fun saveWorkouts(workouts : List<Workout>)

    fun saveAliments(aliments : List<Aliment>)

    fun saveDayConso(dayConso : DayConso)
    fun saveDayConsoHistory(dayConsoHistory: List<DayConso>)
}