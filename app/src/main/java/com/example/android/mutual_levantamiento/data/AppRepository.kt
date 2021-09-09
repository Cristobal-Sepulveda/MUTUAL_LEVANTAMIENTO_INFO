package com.example.android.onematchproject.data

import androidx.lifecycle.Transformations
import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutual_levantamiento.data.dao.LevantamientoDao
import kotlinx.coroutines.*
import com.example.android.mutual_levantamiento.utils.Result

class AppRepository(private val levantamientoDao: LevantamientoDao,
                    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO){

    suspend fun savingLevantamientoToLocalDatabase(levantamiento: LEVANTAMIENTO_DBO) {
        withContext(ioDispatcher) {
            levantamientoDao.saveLevantamiento(levantamiento)
        }
    }

    val levantamientosListFromDatabase = levantamientoDao.getLevantamientos()
}
