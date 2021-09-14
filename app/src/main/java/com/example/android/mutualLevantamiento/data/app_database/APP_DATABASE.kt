package com.example.android.onematchproject.data.app_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.mutualLevantamiento.data.DBO.LEVANTAMIENTO_DBO
import com.example.android.mutualLevantamiento.data.dao.LevantamientoDao


/**
 * Here is the instance of the APP_DATABASE and the method that create the DB when the user start
 * the app.
 */
@Database(entities = [LEVANTAMIENTO_DBO::class], version = 1, exportSchema = false)
abstract class LOCAL_DATABASE: RoomDatabase() {
    abstract val levantamientoDao: LevantamientoDao
}

private lateinit var INSTANCE: LOCAL_DATABASE

fun getDatabase(context: Context): LOCAL_DATABASE {
    synchronized(LOCAL_DATABASE::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                LOCAL_DATABASE::class.java,
                "database").build()
        }
    }
    return INSTANCE
}