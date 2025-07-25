package com.example.appmovil2025.model

import com.google.type.DateTime
import java.util.Date
import java.io.Serializable

data class Conferencia(
    val titulo: String = "",
    val descripcion: String = "",
    val topico: String = "",
    val horafecha: Date = Date(),
    val expositor: String = ""
) : Serializable

