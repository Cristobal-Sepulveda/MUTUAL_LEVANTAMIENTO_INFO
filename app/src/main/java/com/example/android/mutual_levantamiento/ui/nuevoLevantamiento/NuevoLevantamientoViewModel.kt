package com.example.android.mutual_levantamiento.ui.nuevoLevantamiento

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.mutual_levantamiento.base.BaseViewModel
import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.onematchproject.data.AppDataSource
import kotlinx.coroutines.launch


class NuevoLevantamientoViewModel(
    val app: Application, val dataSource: AppDataSource) : BaseViewModel(app) {

    private val _levantamientoIsDone = MutableLiveData(false)
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
            }
        }
    }
}