package com.example.roadtochamp.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.repository.IRepository
import java.time.LocalDate

class DayConsoViewModel(val repository: IRepository) : ViewModel() {

    var dayConsoMutableLiveData = MutableLiveData<DayConso>() // Notifiera tous les observers en cas de changement

    init {
        dayConsoMutableLiveData = repository.getDayConso()
    }

    fun addCalDayConso(cal: Int) {
        val currentDayConso = dayConsoMutableLiveData.value ?: DayConso()
        currentDayConso.addCal(cal)
        dayConsoMutableLiveData.postValue(currentDayConso)
        saveDayConso()
    }

    fun saveDayConso(){
        dayConsoMutableLiveData.value?.let { repository.saveDayConso(it) }
    }

    fun resetCal(){
        val currentDayConso = DayConso()
        dayConsoMutableLiveData.postValue(currentDayConso)
        saveDayConso()
    }

    fun changeDay(){
        if (dayConsoMutableLiveData.value != DayConso(LocalDate.now())){
            var history = this.repository.getDayConsoHistory().value
            val dayConso = dayConsoMutableLiveData.value
            if ((history != null && dayConso != null)) {
                history = (history + dayConso)
                repository.saveDayConsoHistory(history!!)
            }

            val newDayConso = DayConso()
            if (dayConso != null) {
                newDayConso.setGoals(
                    dayConso.getCalGoal(),
                    dayConso.getProtGoal(),
                    dayConso.getGluGoal(),
                    dayConso.getLipGoal())
            }
            dayConsoMutableLiveData.postValue(newDayConso)
        }
    }

}