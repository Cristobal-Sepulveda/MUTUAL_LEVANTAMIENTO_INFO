package com.example.android.mutualLevantamiento.data.domainObject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class LEVANTAMIENTO(
    val torre: String?,
    val piso: String?,
    val unidad: String?,
    val sala: String?,
    val modelo: String?,
    val estado: String?,
    val serial: String?,
    val activo_fijo: String?,
    val ip: String?,
    val mac:String?,
    val usuario: String?,
    val clave: String?,
    val aplicativos_utilizados: String?,
    val id: String = UUID.randomUUID().toString()
): Parcelable