package com.example.android.mutual_levantamiento.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.mutual_levantamiento.R
import com.example.android.mutual_levantamiento.databinding.FragmentNuevoLevantamientoBinding
import com.example.android.mutual_levantamiento.utils.customVariables

class NuevoLevantamientoFragment: Fragment() {

    private lateinit var binding: FragmentNuevoLevantamientoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        var questionIndex = 0

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_nuevo_levantamiento,
            container,
            false)
        binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]

        binding.ingresarDatoButton.setOnClickListener{
              if(questionIndex == 12){
                  Toast.makeText(context, "Computador Ingresado", Toast.LENGTH_LONG).show()
                  questionIndex = 0
                  binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
            }else{
                questionIndex++
                binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
            }
        }

        return binding.root
    }
}