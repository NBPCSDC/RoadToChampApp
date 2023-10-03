package com.example.roadtochamp.model

class WorkoutRepository{

    private val dataSource = WorkoutDataSource

    fun getWorkouts(): List<Workout> {
        return dataSource.getWorkoutList()
    }

    fun getWorkoutFromInternet() : List<Workout>{
        return listOf()
    }
}