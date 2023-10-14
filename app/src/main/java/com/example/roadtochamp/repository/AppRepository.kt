package com.example.roadtochamp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.workout.Workout

class AppRepository(private val externalStorageDataSource: DataSourceExternalStorage) : IRepository {

    override fun getWorkouts(): LiveData<List<Workout>> {
        val workoutsLiveData = MutableLiveData<List<Workout>>()
        val workouts = externalStorageDataSource.getWorkouts()
        workoutsLiveData.value = workouts
        return workoutsLiveData
    }

    override fun getAliments(): LiveData<List<Aliment>> {
        val alimentsLiveData = MutableLiveData<List<Aliment>>()
        val aliments = externalStorageDataSource.getAliments()
        alimentsLiveData.value = aliments
        return alimentsLiveData
    }

    override fun saveWorkouts(workouts: List<Workout>) {
        externalStorageDataSource.setWorkouts(workouts)
    }

    override fun saveAliments(aliments: List<Aliment>) {
        externalStorageDataSource.setAliments(aliments)
    }
}