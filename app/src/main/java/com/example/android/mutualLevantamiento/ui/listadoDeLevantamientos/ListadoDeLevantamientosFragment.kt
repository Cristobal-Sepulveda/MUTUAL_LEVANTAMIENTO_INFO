package com.example.android.mutualLevantamiento.ui.listadoDeLevantamientos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.mutualLevantamiento.Adapter.LevantamientoAdapter
import com.example.android.mutualLevantamiento.R
import com.example.android.mutualLevantamiento.base.BaseFragment
import com.example.android.mutualLevantamiento.databinding.FragmentListadoDeLevantamientosBinding
import com.example.android.mutualLevantamiento.ui.nuevoLevantamiento.NuevoLevantamientoViewModel
import org.koin.android.ext.android.inject

class ListadoDeLevantamientosFragment: BaseFragment() {

    override val _viewModel: ListadoDeLevantamientosViewModel by inject()
    private lateinit var binding: FragmentListadoDeLevantamientosBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_listado_de_levantamientos,
            container,
            false)

        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)



        binding.levantamientoRecyclerView.adapter = LevantamientoAdapter(
            LevantamientoAdapter.OnClickListener{
                _viewModel.displayLevantamientoDetails(it)
            })

        _viewModel.navigateToSelectedLevantamiento.observe(viewLifecycleOwner, {
            if (null != it){
                this.findNavController().navigate(ListadoDeLevantamientosFragmentDirections
                    .actionNavListadoDeLevantamientosToDetailFragment(it))
                _viewModel.displayLevantamientoDetailsComplete()
            }
        })








        return binding.root
    }
}