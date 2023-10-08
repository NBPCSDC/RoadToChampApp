package com.example.roadtochamp.model

class Workout(private val name : String, private val Exos : Array<Exo>) {
    override fun toString(): String {
        return "Workout(name='$name', Exos=${Exos.contentToString()})"
    }
}