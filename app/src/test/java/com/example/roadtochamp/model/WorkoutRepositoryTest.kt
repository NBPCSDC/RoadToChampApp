package com.example.roadtochamp.model

import org.junit.Test

import org.junit.Assert.*

internal class WorkoutRepositoryTest {

    @Test
    fun getWorkoutsNotEmpty() {
        val repo = LocalWorkoutRepository
        assertTrue(repo.getWorkouts().isNotEmpty())
    }

    @Test
    fun getWorkouts() {
        val repo = LocalWorkoutRepository
        println(repo.getWorkouts())
    }
}
