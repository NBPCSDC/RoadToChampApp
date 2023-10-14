package com.example.roadtochamp.model.nutrition

import kotlinx.serialization.Serializable

@Serializable
class Aliment(
    private val name : String,
    private val cal : Double,
    private val prot : Double,
    private val glu : Double,
    private val lip : Double) {
}