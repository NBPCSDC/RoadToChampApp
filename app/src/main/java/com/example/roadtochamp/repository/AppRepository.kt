package com.example.roadtochamp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.model.workout.Workout

class AppRepository(private val externalStorageDataSource: DataSourceExternalStorage) : IRepository {

    override fun getWorkouts(): MutableLiveData<List<Workout>> {
        val workoutsLiveData = MutableLiveData<List<Workout>>()
        val workouts = externalStorageDataSource.getWorkouts()
        workoutsLiveData.value = workouts
        return workoutsLiveData
    }

    override fun getAliments(): MutableLiveData<List<Aliment>> {
        val alimentsLiveData = MutableLiveData<List<Aliment>>()
        val aliments = externalStorageDataSource.getAliments()
        alimentsLiveData.value = aliments
        return alimentsLiveData
    }

    override fun getDayConso(): MutableLiveData<DayConso> {
        val dayConsoLiveData = MutableLiveData<DayConso>()
        val dayConso = externalStorageDataSource.getDayConso()
        dayConsoLiveData.value = dayConso
        return dayConsoLiveData
    }

    override fun getDayConsoHistory(): MutableLiveData<List<DayConso>> {
        val dayConsoHistoryLiveData = MutableLiveData<List<DayConso>>()
        val dayConsoHistory = externalStorageDataSource.getDayConsoHistory()
        dayConsoHistoryLiveData.value = dayConsoHistory
        return dayConsoHistoryLiveData
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