package com.example.android.mutualLevantamiento.ui.nuevoLevantamiento

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.mutualLevantamiento.base.BaseViewModel
import com.example.android.mutualLevantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.onematchproject.data.AppRepository
import kotlinx.coroutines.launch


class NuevoLevantamientoViewModel(
    val app: Application, val dataSource: AppRepository
) : BaseViewModel(app) {

    private val _levantamientoIsDone = MutableLiveData(true)
    val levantamientoIsDone: LiveData<Boolean>
        get() = _levantamientoIsDone

    init{

    }

    fun saveLevantamiento(levantamiento: LEVANTAMIENTO_DBO){
        viewModelScope.launch{
            try{
                dataSource.savingLevantamientoToLocalDatabase(levantamiento)
            }catch(ex: Exception){
                showSnackBar.value = "No se pudo guardar el levantamiento en la Base de Datos"
                saveLevantamiento(levantamiento)
            }
        }
    }

    fun levantamientoReady(){
        _levantamientoIsDone.value = false
    }
    fun levantamientoDone(){
        _levantamientoIsDone.value = true
    }
}