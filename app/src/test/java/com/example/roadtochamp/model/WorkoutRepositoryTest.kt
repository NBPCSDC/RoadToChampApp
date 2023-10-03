package com.example.roadtochamp.model

import org.junit.Test

import org.junit.Assert.*

internal class WorkoutRepositoryTest {

    @Test
    fun getWorkoutsNotEmpty() {
        val dataSource = WorkoutDataSource
        val repo = WorkoutRepository()
        assertTrue(repo.getWorkouts().isNotEmpty())
    }

    @Test
    fun getWorkouts() {
        val dataSource = WorkoutDataSource
        val repo = WorkoutRepository()
        println(repo.getWorkouts())
    }
}
