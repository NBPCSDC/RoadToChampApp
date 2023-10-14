package com.example.roadtochamp.model.workout

class Workout(private val name : String, private val Exos : Array<Exo>) {
    override fun toString(): String {
        return "Workout(name='$name', Exos=${Exos.contentToString()})"
    }
}