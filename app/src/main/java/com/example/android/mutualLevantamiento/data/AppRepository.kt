package com.example.android.onematchproject.data

import androidx.lifecycle.Transformations
import com.example.android.mutualLevantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutualLevantamiento.data.DBO.asDomainModel
import com.example.android.mutualLevantamiento.data.dao.LevantamientoDao
import kotlinx.coroutines.*

class AppRepository(private val levantamientoDao: LevantamientoDao,
                    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO){

    suspend fun savingLevantamientoToLocalDatabase(levantamiento: LEVANTAMIENTO_DBO) {
        withContext(ioDispatcher) {
            levantamientoDao.saveLevantamiento(levantamiento)
        }
    }

    val levantamientosListFromDatabase = Transformations.map(levantamientoDao.getLevantamientos()){
        it.asDomainModel()
    }
}
