package com.example.roadtochamp.view

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.R
import com.example.roadtochamp.model.nutrition.DayConso
import com.example.roadtochamp.view.viewModel.DayConsoViewModel
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.roadtochamp.databinding.FragmentProgressFieldBinding

class ProgressField : Fragment() {

    companion object {
        fun newInstance() = ProgressField()
    }

    private lateinit var binding : FragmentProgressFieldBinding

    private lateinit var dayConsoViewModel: DayConsoViewModel

    private lateinit var progressBarCal: ProgressBar
    private lateinit var progressBarGlu: ProgressBar
    private lateinit var progressBarProt: ProgressBar
    private lateinit var progressBarLip: ProgressBar

    private lateinit var calText : TextView
    private lateinit var gluText : TextView
    private lateinit var protText : TextView
    private lateinit var lipText : TextView

    private lateinit var dayConso : DayConso
    private var calories : Int = 0
    private lateinit var newTheme : Resources.Theme

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentProgressFieldBinding.inflate(layoutInflater)
        val view = binding.root

        progressBarCal = binding.progressBarCal
        progressBarGlu = binding.progressBarGlu
        progressBarProt = binding.progressBarProt
        progressBarLip =  binding.progressBarLip

        calText = binding.calTextField
        gluText = binding.gluText
        protText = binding.protText
        lipText = binding.lipText

        dayConsoViewModel = ViewModelProvider(requireActivity())[DayConsoViewModel::class.java]
        dayConso = dayConsoViewModel.dayConso
        dayConsoViewModel.changeDay()

        val drawableCalCompleted = updateDrawableStyle(R.style.completedProgressBarCalStyle,R.drawable.customcircularprogressbar)
        val drawableCal = updateDrawableStyle(R.style.ProgressBarCalStyle,R.drawable.customcircularprogressbar)
        val drawableCalExceeded = updateDrawableStyle(R.style.ExceededProgressBarCalStyle,R.drawable.customcircularprogressbar)

        progressBarCal.max = dayConso.getCalGoal()
        progressBarProt.max = dayConso.getProtGoal()
        progressBarGlu.max = dayConso.getGluGoal()
        progressBarLip.max = dayConso.getLipGoal()

        dayConsoViewModel.calLiveData.observe(viewLifecycleOwner, Observer {
            print(dayConso.getCal())
            if (dayConsoViewModel.calLiveData.value != null){
                calories = dayConsoViewModel.calLiveData.value!!
            }
            calText.text = dayConsoViewModel.calLiveData.value.toString()
            if (dayConso.isCalGoalAchieved()) {
                if(calories > dayConso.getCalGoal()+200) {
                    progressBarCal.progressDrawable = drawableCalExceeded
                    calText.setTextColor(ContextCompat.getColor(requireContext(), R.color.pourpre))
                    calText.textSize = 25.0F
                }else{
                    progressBarCal.progressDrawable = drawableCalCompleted
                    calText.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_700))
                    calText.textSize = 25.0F
                }
                progressBarCal.progress = calories - dayConso.getCalGoal()
            }else{
                progressBarCal.progressDrawable = drawableCal
                calText.textSize = 20.0F
                calText.setTextColor(ContextCompat.getColor(requireContext(),R.color.purple_500))
                progressBarCal.progress = calories
            }
        })


        dayConsoViewModel.protLiveData.observe(viewLifecycleOwner) {
            protText.text = dayConsoViewModel.protLiveData.value.toString()
            progressBarProt.progress = dayConsoViewModel.protLiveData.value!!
        }

        dayConsoViewModel.gluLiveData.observe(viewLifecycleOwner) {
            gluText.text = dayConsoViewModel.gluLiveData.value.toString()
            progressBarGlu.progress = dayConsoViewModel.gluLiveData.value!!
        }

        dayConsoViewModel.lipLiveData.observe(viewLifecycleOwner) {
            lipText.text = dayConsoViewModel.lipLiveData.value.toString()
            progressBarLip.progress = dayConsoViewModel.lipLiveData.value!!
        }


        // Utilisez dayConsoViewModel pour observer les données ou mettre à jour l'affichage
        return view
    }


    private fun updateDrawableStyle(styleID : Int, drawableID: Int) : Drawable?{
        newTheme = resources.newTheme()
        newTheme.applyStyle(styleID, true)
        val drawable = ResourcesCompat.getDrawable(resources, drawableID, newTheme)
        if (drawable!=null){
            return drawable
        }else{
            println("Probleme de mise a jour du style de drawable :$drawableID")
            return null
        }
    }

}