package com.example.roadtochamp.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.workout.Exo
import com.example.roadtochamp.model.workout.Workout
import com.example.roadtochamp.repository.IRepository

class WorkoutViewModel(repository : IRepository) : ViewModel() {

    val currentWorkout = Workout("test", intArrayOf())
    val workouts : List<Workout> = repository.getWorkouts()

}

