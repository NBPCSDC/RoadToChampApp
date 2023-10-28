@file:Suppress("UNCHECKED_CAST")

package com.example.roadtochamp.injection

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.repository.AppRepository
import com.example.roadtochamp.view.viewModel.AlimentViewModel
import com.example.roadtochamp.view.viewModel.DayConsoViewModel
import com.example.roadtochamp.view.viewModel.WorkoutViewModel

class ViewModelFactory(private val context: Context, private val repository: AppRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {
            return WorkoutViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(AlimentViewModel::class.java)) {
            return AlimentViewModel(repository) as T
        }else if(modelClass.isAssignableFrom(DayConsoViewModel::class.java)) {
            return DayConsoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
