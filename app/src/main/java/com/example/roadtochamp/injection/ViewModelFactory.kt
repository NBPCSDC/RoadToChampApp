@file:Suppress("UNCHECKED_CAST")

package com.example.roadtochamp.injection

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.repository.AppRepository
import com.example.roadtochamp.view.AlimentViewModel
import com.example.roadtochamp.view.WorkoutViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {
            val repository = AppRepository(DataSourceExternalStorage(context))
            return WorkoutViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(AlimentViewModel::class.java)) {
            val repository = AppRepository(DataSourceExternalStorage(context))
            return AlimentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
