package com.example.roadtochamp.dataManager

import android.content.Context
import android.content.SharedPreferences
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.model.workout.Workout

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DataSourceExternalStorage(context: Context) : IDataSource {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("Data", Context.MODE_PRIVATE)

    private val json = Json { encodeDefaults = true }

    override fun getWorkouts() : List<Workout> {
        val serializedData = sharedPreferences.getString("workouts", "")
        if (serializedData.isNullOrEmpty()) {
            return emptyList()
        }
        return try {
            json.decodeFromString(serializedData)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun getAliments(): List<Aliment> {
        val serializedData = sharedPreferences.getString("aliments", "")
        if (serializedData.isNullOrEmpty()) {
            return emptyList()
        }
        return try {
            json.decodeFromString(serializedData)
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun getDayConso(): DayConso {
        val serializedData = sharedPreferences.getString("dayConso", "")
        if (serializedData.isNullOrEmpty()) {
            return DayConso()
        }
        return try {
            json.decodeFromString(serializedData)
        } catch (e: Exception) {
            DayConso()
        }
    }

    override fun getDayConsoHistory(): List<DayConso> {
        val serializedData = sharedPreferences.getString("dayConsoHistory", "")
        if (serializedData.isNullOrEmpty()) {
            return listOf()
        }
        return try {
            json.decodeFromString(serializedData)
        } catch (e: Exception) {
            listOf()
        }
    }

    override fun setWorkouts(workouts: List<Workout>) {
        val serializedData = json.encodeToString(workouts)
        with(sharedPreferences.edit()) {
            putString("workouts", serializedData)
            apply()
        }
    }

    override fun setAliments(aliments: List<Aliment>) {
        val serializedData = json.encodeToString(aliments)
        with(sharedPreferences.edit()) {
            putString("aliments", serializedData)
            apply()
        }
    }

    override fun setDayConso(dayConso: DayConso) {
        val serializedData = json.encodeToString(dayConso)
        with(sharedPreferences.edit()) {
            putString("dayConso", serializedData)
            apply()
        }
    }

    override fun setDayConsoHistory(history: List<DayConso>) {
        val serializedData = json.encodeToString(history)
        with(sharedPreferences.edit()) {
            putString("dayConsoHistory", serializedData)
            apply()
        }
    }

}