package com.example.android.mutual_levantamiento.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.mutual_levantamiento.R
import com.example.android.mutual_levantamiento.databinding.FragmentNuevoLevantamientoBinding

class NuevoLevantamientoFragment: Fragment() {

    private lateinit var binding: FragmentNuevoLevantamientoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_nuevo_levantamiento,
            container,
            false)

        binding.ingresarDatoButton.setOnClickListener{

        }

        return binding.root
    }
}