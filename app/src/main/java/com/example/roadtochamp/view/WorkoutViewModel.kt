package com.example.roadtochamp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.workout.Workout
import com.example.roadtochamp.repository.IRepository

class WorkoutViewModel(repository : IRepository) : ViewModel() {

    //Creating liveData
    val currentWorkout = MutableLiveData<Workout>()
    val workouts : LiveData<List<Workout>> = repository.getWorkouts()

}

