package com.example.android.mutualLevantamiento.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.mutualLevantamiento.R
import com.example.android.mutualLevantamiento.base.BaseFragment
import com.example.android.mutualLevantamiento.databinding.FragmentDetailBinding
import org.koin.android.ext.android.inject


class DetailFragment: BaseFragment() {

    override val _viewModel: DetailViewModel by inject()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false)

        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
        val levantamiento = DetailFragmentArgs.fromBundle(requireArguments()).levantamientoSeleccionado
        binding.levantamiento = levantamiento

        println("$levantamiento")

        return binding.root
    }
}