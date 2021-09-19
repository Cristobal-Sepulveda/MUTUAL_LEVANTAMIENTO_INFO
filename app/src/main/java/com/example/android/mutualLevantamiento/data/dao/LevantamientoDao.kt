package com.example.android.mutualLevantamiento.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.mutualLevantamiento.data.DBO.LEVANTAMIENTO_DBO


@Dao
interface LevantamientoDao {

    @Query("select * from LEVANTAMIENTO_DBO where id = :levantamiento_id")
    fun getLevantamientoById(levantamiento_id: String): LEVANTAMIENTO_DBO

    @Query("select * from LEVANTAMIENTO_DBO")
    fun getLevantamientos(): List<LEVANTAMIENTO_DBO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLevantamiento(levantamiento: LEVANTAMIENTO_DBO)

    @Query("delete from LEVANTAMIENTO_DBO")
    fun deleteLevantamientos()
}