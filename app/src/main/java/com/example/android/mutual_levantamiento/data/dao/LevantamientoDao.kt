package com.example.android.mutual_levantamiento.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.mutual_levantamiento.data.DBO.LEVANTAMIENTO_DBO


@Dao
interface LevantamientoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLevantamiento(levantamiento: LEVANTAMIENTO_DBO)

    @Query("select * from LEVANTAMIENTO_DBO where id = :levantamiento_id")
    fun getLevantamiento(levantamiento_id: String): LEVANTAMIENTO_DBO

    @Query("select * from LEVANTAMIENTO_DBO")
    fun getLevantamientos(): List<LEVANTAMIENTO_DBO>

    @Query("delete from LEVANTAMIENTO_DBO")
    fun deleteLevantamientos()
}