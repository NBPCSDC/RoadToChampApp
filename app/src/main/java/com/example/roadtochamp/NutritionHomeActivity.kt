package com.example.roadtochamp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.injection.ViewModelFactory
import com.example.roadtochamp.repository.AppRepository
import com.example.roadtochamp.view.viewModel.DayConsoViewModel
import java.lang.Exception


class NutritionHomeActivity : AppCompatActivity() {

    lateinit var addCalButton : Button
    lateinit var caloriesField : EditText
    lateinit var alimentButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_home)

        addCalButton = findViewById(R.id.addButton)
        caloriesField = findViewById(R.id.calorieField)
        alimentButton = findViewById(R.id.alimentsButton)

        val repository = AppRepository(DataSourceExternalStorage(this))
        val viewModelFactory = ViewModelFactory(this, repository)
        val dayConsoViewModel = ViewModelProvider(this,viewModelFactory)[DayConsoViewModel::class.java]

        addCalButton.setOnClickListener {
            try{
                val cal = caloriesField.text.toString().toInt()
                dayConsoViewModel.addCalDayConso(cal)
            }catch(e : Exception){
                println("erreur calorie n'est pas Double")
            }
        }

        alimentButton.setOnClickListener {
            dayConsoViewModel.resetCal()
        }


    }
}