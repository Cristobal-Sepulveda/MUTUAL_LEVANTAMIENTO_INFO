package com.example.android.onematchproject.data

import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutual_levantamiento.data.dao.LevantamientoDao
import kotlinx.coroutines.*

class AppRepository(private val levantamientoDao: LevantamientoDao,
                    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): AppDataSource {

    override suspend fun savingLevantamientoToLocalDatabase(levantamiento: LEVANTAMIENTO_DBO) {
        TODO("Not yet implemented")
    }

    override suspend fun gettingLevantamientosFromDatabase(): List<LEVANTAMIENTO_DBO> {
        TODO("Not yet implemented")
    }


}
