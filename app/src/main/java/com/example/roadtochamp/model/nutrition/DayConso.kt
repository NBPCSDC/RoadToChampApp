package com.example.roadtochamp.model.nutrition

import com.example.roadtochamp.utils.DateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class DayConso(
    @Serializable(with = DateSerializer::class)
    private val date: LocalDate = LocalDate.now(),
    private var cal: Int = 0,
    private var prot: Int = 0,
    private var glu: Int = 0,
    private var lip: Int = 0,
    private var calGoal: Int = 1800,
    private var protGoal: Int = 0,
    private var gluGoal: Int = 0,
    private var lipGoal: Int = 0
) {

    fun getCal(): Int {
        return cal
    }

    fun getProt() : Int{
        return prot
    }

    fun getGlu() : Int{
        return glu
    }

    fun getLip() : Int{
        return lip
    }

    // Getter pour calGoal
    fun getCalGoal(): Int {
        return calGoal
    }

    // Getter pour protGoal
    fun getProtGoal(): Int {
        return protGoal
    }

    // Getter pour gluGoal
    fun getGluGoal(): Int {
        return gluGoal
    }

    // Getter pour lipGoal
    fun getLipGoal(): Int {
        return lipGoal
    }

    fun addCal(calToAdd: Int) {
        require(calToAdd >= 0) { "La valeur de calToAdd doit être positive ou nulle." }
        cal += calToAdd
    }

    fun addProt(protToAdd: Int) {
        require(protToAdd >= 0) { "La valeur de protToAdd doit être positive ou nulle." }
        prot += protToAdd
    }

    fun addGlu(gluToAdd: Int) {
        require(gluToAdd >= 0) { "La valeur de gluToAdd doit être positive ou nulle." }
        glu += gluToAdd
    }

    fun addLip(lipToAdd: Int) {
        require(lipToAdd >= 0) { "La valeur de lipToAdd doit être positive ou nulle." }
        lip += lipToAdd
    }

    fun isCalGoalAchieved(): Boolean {
        return cal >= calGoal
    }

    fun isProtGoalAchieved(): Boolean {
        return prot >= protGoal
    }

    fun isGluGoalAchieved(): Boolean {
        return glu >= gluGoal
    }

    fun isLipGoalAchieved(): Boolean {
        return lip >= lipGoal
    }

    fun setGoals(calGoal: Int, protGoal: Int, gluGoal: Int, lipGoal: Int){
        this.calGoal = calGoal
        this.protGoal = protGoal
        this.gluGoal = gluGoal
        this.lipGoal = lipGoal
    }

    override fun toString(): String {
        return "DayConso(date=$date, cal=$cal)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DayConso

        if (date != other.date) return false

        return true
    }


}