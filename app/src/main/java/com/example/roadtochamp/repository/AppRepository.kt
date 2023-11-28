package com.example.roadtochamp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.model.workout.Workout

class AppRepository(private val externalStorageDataSource: DataSourceExternalStorage) : IRepository {

    override fun getWorkouts(): List<Workout> {
        val workouts = externalStorageDataSource.getWorkouts()
        return workouts
    }

    override fun getAliments(): List<Aliment> {
        val aliments = externalStorageDataSource.getAliments()
        return aliments
    }

    override fun getDayConso(): DayConso {
        val dayConso = externalStorageDataSource.getDayConso()
        return dayConso
    }

    override fun getDayConsoHistory(): List<DayConso> {
        val dayConsoHistory = externalStorageDataSource.getDayConsoHistory()
        return dayConsoHistory
    }

    override fun saveWorkouts(workouts: List<Workout>) {
        externalStorageDataSource.setWorkouts(workouts)
    }

    override fun saveAliments(aliments: List<Aliment>) {
        externalStorageDataSource.setAliments(aliments)
    }

    override fun saveDayConso(dayConso: DayConso) {
        externalStorageDataSource.setDayConso(dayConso)
    }

    override fun saveDayConsoHistory(dayConsoHistory: List<DayConso>) {
        externalStorageDataSource.setDayConsoHistory(dayConsoHistory)
    }

}