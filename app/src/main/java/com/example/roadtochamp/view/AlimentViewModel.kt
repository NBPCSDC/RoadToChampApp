package com.example.roadtochamp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.repository.IRepository

class AlimentViewModel(repository : IRepository) : ViewModel() {

    private var aliments : LiveData<List<Aliment>> = repository.getAliments()

}