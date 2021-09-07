package com.example.android.onematchproject.data

import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutual_levantamiento.data.dao.LevantamientoDao
import kotlinx.coroutines.*
import com.example.android.mutual_levantamiento.utils.Result

class AppRepository(private val levantamientoDao: LevantamientoDao,
                    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): AppDataSource {

    override suspend fun savingLevantamientoToLocalDatabase(levantamiento: LEVANTAMIENTO_DBO) {
        withContext(ioDispatcher) {
            levantamientoDao.saveLevantamiento(levantamiento)
        }
    }

    override suspend fun gettingLevantamientosFromDatabase(): List<LEVANTAMIENTO_DBO> =
        withContext(ioDispatcher) {
            try {
                val list = Result.Success(levantamientoDao.getLevantamientos())
                return@withContext list.data
            } catch (ex: Exception) {
                val listError: List<LEVANTAMIENTO_DBO> = listOf()
                Result.Error(ex.localizedMessage)
                return@withContext listError
            }
        }
}
