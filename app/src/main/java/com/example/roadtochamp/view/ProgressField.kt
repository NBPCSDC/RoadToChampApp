package com.example.roadtochamp.view

import android.R.color
import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.graphics.alpha
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roadtochamp.R
import com.example.roadtochamp.view.viewModel.DayConsoViewModel


class ProgressField : Fragment() {

    companion object {
        fun newInstance() = ProgressField()
    }

    private lateinit var dayConsoViewModel: DayConsoViewModel
    private lateinit var progressBarCal: ProgressBar
    private lateinit var progressBarGlu: ProgressBar
    private lateinit var progressBarProt: ProgressBar
    private lateinit var progressBarLip: ProgressBar
    lateinit var calText : TextView

    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_progress_field, container, false)

        progressBarCal = view.findViewById(R.id.progressBarCal)
        progressBarGlu = view.findViewById(R.id.progressBarGlu)
        progressBarProt = view.findViewById(R.id.progressBarProt)
        progressBarLip = view.findViewById(R.id.progressBarLip)
        calText = view.findViewById(R.id.calTextField)

        dayConsoViewModel = ViewModelProvider(requireActivity())[DayConsoViewModel::class.java]
        dayConsoViewModel.changeDay()

        val dayConso = dayConsoViewModel.dayConsoMutableLiveData
        if (dayConso != null) {
            progressBarCal.max = dayConso.value!!.getCalGoal()
        }

        // Utilisez dayConsoViewModel pour observer les données ou mettre à jour l'affichage
        dayConsoViewModel.dayConsoMutableLiveData.observe(viewLifecycleOwner, Observer {
            calText.text = dayConso.value!!.getCal().toString()
            if (dayConso.value!!.isCalGoalAchieved()) {
            }
            progressBarCal.progress = dayConso.value!!.getCal()
            println(progressBarCal.progress)
        })
        return view
    }

}