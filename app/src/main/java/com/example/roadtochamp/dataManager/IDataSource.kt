package com.example.roadtochamp.dataManager

import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.model.workout.Workout

interface IDataSource {
    fun getWorkouts(): List<Workout>
    fun getAliments():List<Aliment>
    fun getDayConso() : DayConso?
    fun getDayConsoHistory() : List<DayConso>
    fun setWorkouts(workouts : List<Workout>)
    fun setAliments(aliments : List<Aliment>)
    fun setDayConso(dayConso: DayConso)
    fun setDayConsoHistory(history : List<DayConso>)
}