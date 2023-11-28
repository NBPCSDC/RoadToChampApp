package com.example.roadtochamp.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.R
import com.example.roadtochamp.dataManager.DataSourceExternalStorage
import com.example.roadtochamp.injection.ViewModelFactory
import com.example.roadtochamp.repository.AppRepository
import com.example.roadtochamp.view.viewModel.DayConsoViewModel
import java.lang.Exception


class NutritionHomeActivity : AppCompatActivity() {

    lateinit var addCalButton : Button
    lateinit var caloriesField : EditText
    lateinit var protField : EditText
    lateinit var gluField : EditText
    lateinit var lipField: EditText
    lateinit var alimentButton : Button
    lateinit var showMacrosButton : ImageButton
    lateinit var fieldsMacros : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_home)

        addCalButton = findViewById(R.id.addButton)

        caloriesField = findViewById(R.id.calorieField)
        protField = findViewById(R.id.protField)
        gluField = findViewById(R.id.gluField)
        lipField = findViewById(R.id.lipField)

        alimentButton = findViewById(R.id.alimentsButton)
        showMacrosButton = findViewById(R.id.showMacrosButton)
        fieldsMacros = findViewById(R.id.fieldsMacros)

        val repository = AppRepository(DataSourceExternalStorage(this))
        val viewModelFactory = ViewModelFactory(this, repository)
        val dayConsoViewModel = ViewModelProvider(this,viewModelFactory)[DayConsoViewModel::class.java]

        addCalButton.setOnClickListener {
            val cal = try{
                caloriesField.text.toString().toInt()
            }catch (_ : Exception){
                0
            }
            val prot = try{
                protField.text.toString().toInt()
            }catch (_ : Exception){
                0
            }
            val glu = try{
                gluField.text.toString().toInt()
            }catch (_ : Exception){
                0
            }
            val lip = try{
                lipField.text.toString().toInt()
            }catch (_ : Exception){
                0
            }
            dayConsoViewModel.updateDayConso(cal, prot, glu, lip)
        }

        alimentButton.setOnClickListener {
            dayConsoViewModel.resetCal()
        }

        showMacrosButton.setOnClickListener{
            if(fieldsMacros.visibility == View.GONE){
                fieldsMacros.visibility = View.VISIBLE
            }else{
                fieldsMacros.visibility = View.GONE
            }
        }

    }
}