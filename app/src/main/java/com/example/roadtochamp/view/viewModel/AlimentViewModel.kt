package com.example.roadtochamp.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.nutrition.Aliment
import com.example.roadtochamp.repository.IRepository

class AlimentViewModel(repository : IRepository) : ViewModel() {

    private var aliments : List<Aliment> = repository.getAliments()

}