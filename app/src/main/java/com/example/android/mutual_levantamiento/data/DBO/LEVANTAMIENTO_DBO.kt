package com.example.android.mutual_levantamiento.data.DBO

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class LEVANTAMIENTO_DBO(
    val torre: String,
    val piso: String,
    val unidad: String,
    val serial: Double,
    val activo_fijo: Double,
    val ip: String,
    val mac:String,
    val usuario: String,
    val clave: String,
    val aplicativos_utilizados: String,
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
    )