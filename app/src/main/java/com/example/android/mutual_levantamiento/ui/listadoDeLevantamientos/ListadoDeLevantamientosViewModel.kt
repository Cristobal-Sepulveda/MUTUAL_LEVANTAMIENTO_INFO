package com.example.android.mutual_levantamiento.ui.listadoDeLevantamientos

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.mutual_levantamiento.base.BaseViewModel
import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.onematchproject.data.AppRepository
import kotlinx.coroutines.launch

class ListadoDeLevantamientosViewModel(
    val app: Application, val dataSource: AppRepository
) : BaseViewModel(app) {


    val levantamientosInDatabase = dataSource.levantamientosListFromDatabase

    val levantamientosToScreen: MediatorLiveData<List<LEVANTAMIENTO_DBO>> = MediatorLiveData()

        init{
            viewModelScope.launch{
                levantamientosToScreen.addSource(levantamientosInDatabase){
                    levantamientosToScreen.value = it
                }
            }
        }
}