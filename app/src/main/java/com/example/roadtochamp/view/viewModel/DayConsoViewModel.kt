package com.example.roadtochamp.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.repository.IRepository
import java.time.LocalDate

class DayConsoViewModel(val repository: IRepository) : ViewModel() {

    var dayConso : DayConso = repository.getDayConso()
    val calLiveData = MutableLiveData<Int>(dayConso.getCal())
    val protLiveData = MutableLiveData<Int>(dayConso.getProt())
    val gluLiveData = MutableLiveData<Int>(dayConso.getGlu())
    val lipLiveData = MutableLiveData<Int>(dayConso.getLip())


    fun updateDayConso(cal :Int, prot : Int, glu : Int, lip : Int){
        addCal(cal)
        addLip(lip)
        addProt(prot)
        addGlu(glu)

        saveDayConso()
    }
    private fun addCal(cal: Int) {
        if(cal !=0) {
            dayConso.addCal(cal)
            calLiveData.postValue(dayConso.getCal())
        }
    }

    private fun addProt(prot : Int){
        if(prot != 0) {
            dayConso.addProt(prot)
            protLiveData.postValue(dayConso.getProt())
        }
    }

    private fun addGlu(glu : Int){
        if(glu != 0){
            dayConso.addGlu(glu)
            gluLiveData.postValue(dayConso.getGlu())
        }
    }

    private fun addLip(lip : Int){
        if(lip != 0) {
            dayConso.addLip(lip)
            lipLiveData.postValue(dayConso.getLip())
        }
    }


    private fun saveDayConso(){
        repository.saveDayConso(dayConso)
    }

    fun resetCal(){
        dayConso = DayConso()
        calLiveData.postValue(0)
        protLiveData.postValue(0)
        lipLiveData.postValue(0)
        gluLiveData.postValue(0)
        saveDayConso()
    }

    fun changeDay(){
        if (dayConso != DayConso(LocalDate.now())){
            var history = this.repository.getDayConsoHistory()
            history = (history + dayConso)
            repository.saveDayConsoHistory(history!!)
            val newDayConso = DayConso()
            if (dayConso != null) {
                newDayConso.setGoals(
                    dayConso.getCalGoal(),
                    dayConso.getProtGoal(),
                    dayConso.getGluGoal(),
                    dayConso.getLipGoal())
            }
            calLiveData.postValue(0)
            protLiveData.postValue(0)
            lipLiveData.postValue(0)
            gluLiveData.postValue(0)
        }
    }

}