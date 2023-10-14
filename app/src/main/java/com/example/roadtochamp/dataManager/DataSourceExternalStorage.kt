package com.example.roadtochamp.dataManager

import android.content.Context
import android.content.SharedPreferences
import com.example.roadtochamp.model.nutrition.Aliment
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

}