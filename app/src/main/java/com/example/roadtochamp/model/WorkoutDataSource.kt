package com.example.roadtochamp.model

object WorkoutDataSource {

    fun getWorkoutList() : List<Workout>{
        return listOf(
            Workout("upper1",arrayOf(
                Exo("Développé Incliné",150),
                Exo("Tractions Lestées", 120),
                Exo("Elevations Frontales", 90),
                Exo("Curl Incliné", 120),
                Exo("Elevations latérales", 90)
            )
            ),
            Workout("lower",arrayOf(
                Exo("Squat / Leg Press",120),
                Exo("RDL", 90),
                Exo("Leg Extension", 90),
                Exo("Extensions Mollets", 60),
                Exo("Elevations latérales penché", 60)
            )
            ),
            Workout("upper2",arrayOf(
                Exo("Overhead Press",150),
                Exo("Développé couché / Dips", 120),
                Exo("Tractions Bras", 90),
                Exo("Oiseau Assis", 60),
                Exo("Upright Row", 60)
            )
            ))
    }
}