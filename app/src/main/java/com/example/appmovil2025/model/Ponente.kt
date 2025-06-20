package com.example.appmovil2025.model

data class Ponente(
    var nombre: String = "",
    var profesion: String = "",
    var trabajo: String = "",
    var biografia: String = "",
    var twitter: String = "",   // ✅ Corregido: estaba mal escrito
    var imagen: String = "",
    var categoria: Int = 0
)

