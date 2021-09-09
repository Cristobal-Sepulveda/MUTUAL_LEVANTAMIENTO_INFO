package com.example.android.mutual_levantamiento.ui.listadoDeLevantamientos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.mutual_levantamiento.R
import com.example.android.mutual_levantamiento.base.BaseFragment
import com.example.android.mutual_levantamiento.databinding.FragmentListadoDeLevantamientosBinding
import com.example.android.mutual_levantamiento.ui.nuevoLevantamiento.NuevoLevantamientoViewModel
import org.koin.android.ext.android.inject

class ListadoDeLevantamientosFragment: BaseFragment() {

    override val _viewModel: NuevoLevantamientoViewModel by inject()
    private lateinit var binding: FragmentListadoDeLevantamientosBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_listado_de_levantamientos,
            container,
            false)




        return binding.root
    }
}