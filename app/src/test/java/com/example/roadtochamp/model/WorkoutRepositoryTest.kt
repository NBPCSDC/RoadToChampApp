package com.example.roadtochamp.model

import android.app.Activity
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.repository.AppRepository
import org.junit.Test

import org.junit.Assert.*

internal class WorkoutRepositoryTest {

    @Test
    fun getWorkoutsNotEmpty() {
        val repo = AppRepository(DataSourceExternalStorage(Activity()))
        repo.getWorkouts().value?.let { assertTrue(it.isEmpty()) }
    }

    @Test
    fun getWorkouts() {
        val repo = AppRepository(DataSourceExternalStorage(Activity()))
        println(repo.getWorkouts())
    }
}
