package com.example.android.onematchproject.data

import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO

interface AppDataSource {

    /**
     * Methods to interact with the local database
     * */
    suspend fun savingLevantamientoToLocalDatabase(levantamiento: LEVANTAMIENTO_DBO)
    suspend fun gettingLevantamientosFromDatabase(): List<LEVANTAMIENTO_DBO>
}