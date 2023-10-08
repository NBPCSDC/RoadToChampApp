package com.example.roadtochamp.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.model.LocalWorkoutRepository
import com.example.roadtochamp.view.WorkoutViewModel

object ViewModelFactory : ViewModelProvider.Factory {
    private val workoutRepository: LocalWorkoutRepository = LocalWorkoutRepository
//    private val userRepository: UserRepository = UserRepository(UserDataSource()) // Initialisez votre UserRepository ici

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {
            return WorkoutViewModel(workoutRepository) as T
            // } else if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            //   return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
