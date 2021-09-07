package com.example.android.mutual_levantamiento.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
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

        val estados = resources.getStringArray(R.array.estados)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, estados)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
        binding.textField.visibility = View.GONE
        binding.autoCompleteTextView.visibility = View.GONE

        binding.ingresarDatoButton.setOnClickListener{
            if(questionIndex == 12){
                Toast.makeText(context, "Computador Ingresado", Toast.LENGTH_LONG).show()
                questionIndex = 0
                closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
            }
            if(questionIndex == 4){
                questionIndex++
                binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                binding.datoIngresadoEditText.visibility = View.GONE
                binding.textField.visibility = View.VISIBLE
                binding.autoCompleteTextView.visibility = View.VISIBLE
                closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
            }else{
                questionIndex++
                closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                binding.datoIngresadoEditText.visibility = View.VISIBLE
                binding.textField.visibility = View.GONE
                binding.autoCompleteTextView.visibility = View.GONE
            }
        }

        return binding.root
    }

    private fun closeKeyboardAndClearEditText(view: View) {
        binding.datoIngresadoEditText.text.clear()
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}