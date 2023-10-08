package com.example.roadtochamp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.Workout
import com.example.roadtochamp.model.WorkoutRepository
import kotlin.random.Random

class WorkoutViewModel(repository : WorkoutRepository) : ViewModel() {

    //Creating liveData
    val currentWorkout = MutableLiveData<Workout>()
    val workouts :List<Workout> = repository.getWorkouts()

    fun changeWorkout(){
        currentWorkout.postValue(workouts[Random.nextInt(0,3)])
    }
}

