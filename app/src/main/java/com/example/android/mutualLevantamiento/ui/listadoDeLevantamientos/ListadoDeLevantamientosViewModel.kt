package com.example.android.mutualLevantamiento.ui.listadoDeLevantamientos

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.mutualLevantamiento.base.BaseViewModel
import com.example.android.mutualLevantamiento.data.domainObject.LEVANTAMIENTO
import com.example.android.onematchproject.data.AppRepository
import kotlinx.coroutines.launch

class ListadoDeLevantamientosViewModel(
    val app: Application, val dataSource: AppRepository
) : BaseViewModel(app) {


    val levantamientosInDatabase = dataSource.levantamientosListFromDatabase

    private val _levantamientosListInDatabase = MutableLiveData<List<LEVANTAMIENTO>>()
    val levantamientosListInDatabase: LiveData<List<LEVANTAMIENTO>>
        get()=_levantamientosListInDatabase

    private val _navigateToSelectedLevantamiento = MutableLiveData<LEVANTAMIENTO>()
    val navigateToSelectedLevantamiento: LiveData<LEVANTAMIENTO>
        get() = _navigateToSelectedLevantamiento

    val levantamientosToScreen: MediatorLiveData<List<LEVANTAMIENTO>> = MediatorLiveData()

        init{
            viewModelScope.launch{
                levantamientosToScreen.addSource(levantamientosInDatabase){
                    levantamientosToScreen.value = it
                }
                _levantamientosListInDatabase.value = dataSource.levantamientosListFromDatabase.value
            }
        }

    fun displayLevantamientoDetails(levantamiento: LEVANTAMIENTO){
        _navigateToSelectedLevantamiento.value = levantamiento
    }

    fun displayLevantamientoDetailsComplete() {
        _navigateToSelectedLevantamiento.value = null
    }
}