package com.example.android.mutualLevantamiento.ui.nuevoLevantamiento

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.mutualLevantamiento.R
import com.example.android.mutualLevantamiento.base.BaseFragment
import com.example.android.mutualLevantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutualLevantamiento.databinding.FragmentNuevoLevantamientoBinding
import com.example.android.mutualLevantamiento.utils.customVariables
import org.koin.android.ext.android.inject

class NuevoLevantamientoFragment(): BaseFragment() {

    override val _viewModel: NuevoLevantamientoViewModel by inject()

    private lateinit var binding: FragmentNuevoLevantamientoBinding
    private var questionIndex = 0
    var datosIngresadosEnEditText = arrayListOf<String>()
    var objectToDatabase = LEVANTAMIENTO_DBO(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_nuevo_levantamiento,
            container,
            false)

        binding.viewModel = _viewModel
        binding.lifecycleOwner = this


        val estados = resources.getStringArray(R.array.estados)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, estados)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
        binding.textField.visibility = View.GONE
        binding.autoCompleteTextView.visibility = View.GONE

        binding.ingresarDatoButton.setOnClickListener{
            when(questionIndex){
                12 ->{
                    binding.ingresarDatoButton.text = "SIGUIENTE"
                    datosIngresadosEnEditText.add(binding.datoIngresadoEditText.text.toString())
                    Toast.makeText(context, "Computador Ingresado", Toast.LENGTH_LONG).show()
                    questionIndex = 0
                    closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                    binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                    Log.i("TAG", questionIndex.toString())
                    objectToDatabase = LEVANTAMIENTO_DBO(
                        datosIngresadosEnEditText[0],
                        datosIngresadosEnEditText[1],
                        datosIngresadosEnEditText[2],
                        datosIngresadosEnEditText[3],
                        datosIngresadosEnEditText[4],
                        datosIngresadosEnEditText[5],
                        datosIngresadosEnEditText[6],
                        datosIngresadosEnEditText[7],
                        datosIngresadosEnEditText[8],
                        datosIngresadosEnEditText[9],
                        datosIngresadosEnEditText[10],
                        datosIngresadosEnEditText[11],
                        datosIngresadosEnEditText[12]
                    )
                    Log.i("TAG", "$objectToDatabase")
                    _viewModel.levantamientoReady()
                }
                11 ->{
                    Log.i("TAG", questionIndex.toString())
                    datosIngresadosEnEditText.add(binding.datoIngresadoEditText.text.toString())
                    questionIndex++
                    binding.ingresarDatoButton.text = "Guardar Levantamiento"
                    closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                    binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                }
                4 ->{
                    Log.i("TAG", questionIndex.toString())
                    datosIngresadosEnEditText.add(binding.datoIngresadoEditText.text.toString())
                    questionIndex++
                    binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                    binding.datoIngresadoEditText.visibility = View.GONE
                    binding.textField.visibility = View.VISIBLE
                    binding.autoCompleteTextView.visibility = View.VISIBLE
                    closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                }
                5 ->{
                    Log.i("TAG", binding.autoCompleteTextView.text.toString())
                    datosIngresadosEnEditText.add(binding.autoCompleteTextView.text.toString())
                    questionIndex++
                    closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                    binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                    binding.datoIngresadoEditText.visibility = View.VISIBLE
                    binding.textField.visibility = View.GONE
                    binding.autoCompleteTextView.visibility = View.GONE
                }
                else ->{
                    Log.i("TAG", questionIndex.toString())
                    datosIngresadosEnEditText.add(binding.datoIngresadoEditText.text.toString())
                    closeKeyboardAndClearEditText(binding.datoIngresadoEditText)
                    questionIndex++
                    binding.datoSolicitadoTextView.text = customVariables.listOfRequiredData[questionIndex]
                    binding.datoIngresadoEditText.visibility = View.VISIBLE
                    binding.textField.visibility = View.GONE
                    binding.autoCompleteTextView.visibility = View.GONE
                }
            }
        }

        _viewModel.levantamientoIsDone.observe(viewLifecycleOwner, {
            if(!it){
                _viewModel.saveLevantamiento(objectToDatabase)
                _viewModel.levantamientoDone()
            }
        })
        return binding.root
    }

    private fun closeKeyboardAndClearEditText(view: View) {
        binding.datoIngresadoEditText.text.clear()
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}