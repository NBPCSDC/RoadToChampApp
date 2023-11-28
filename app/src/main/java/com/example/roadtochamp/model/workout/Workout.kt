package com.example.roadtochamp.model.workout

class Workout(private val name: String, private val Exos: IntArray) {
    override fun toString(): String {
        return "Workout(name='$name', Exos=${Exos.contentToString()})"
    }
}