package com.example.android.mutual_levantamiento

import android.app.Application
import android.app.NotificationManager
import androidx.core.content.ContextCompat
import androidx.work.*
import com.example.android.mutual_levantamiento.ui.nuevoLevantamiento.NuevoLevantamientoViewModel
import com.example.android.onematchproject.data.AppDataSource
import com.example.android.onematchproject.data.AppRepository
import com.example.android.onematchproject.data.app_database.getDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()

        /**
         * using Koin Library as a service locator
         */
        val myModule = module {

            //Declare singleton definitions to be later injected using by inject()

            single {
                NuevoLevantamientoViewModel(
                    get(),
                    get() as AppDataSource
                )
            }

            //LOCAL_DATABASE, here im creating the local database in the first start and
            // after that, the db instance persist on the User phone, even if he close the app
            single{getDatabase(this@MyApp).levantamientoDao}

            //REPOSITORY
            single{ AppRepository(get()) as AppDataSource}
        }

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(myModule))
        }

        val notificationManager = ContextCompat.getSystemService(
                applicationContext,
                NotificationManager::class.java
        ) as NotificationManager
    }
}
