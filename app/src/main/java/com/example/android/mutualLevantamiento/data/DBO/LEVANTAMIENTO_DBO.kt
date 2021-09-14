package com.example.android.mutualLevantamiento.data.DBO

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.mutualLevantamiento.data.domainObject.LEVANTAMIENTO
import java.util.*

@Entity
data class LEVANTAMIENTO_DBO(
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
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
    )

//Add an extension function which converts from database objects to domain objects:
fun List<LEVANTAMIENTO_DBO>.asDomainModel(): List<LEVANTAMIENTO> {
    return map {
        LEVANTAMIENTO (
            torre = it.torre,
            piso = it.piso,
            unidad = it.unidad,
            sala = it.sala,
            modelo = it.modelo,
            estado = it.estado,
            serial = it.serial,
            activo_fijo = it.activo_fijo,
            ip = it.ip,
            mac = it.mac,
            usuario = it.usuario,
            clave = it.clave,
            aplicativos_utilizados = it.aplicativos_utilizados,
            id = it.id,
        )
    }
}