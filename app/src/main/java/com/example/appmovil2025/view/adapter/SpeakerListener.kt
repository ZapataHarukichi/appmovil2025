package com.example.appmovil2025.view.adapter

import com.example.appmovil2025.model.Ponente

interface SpeakerListener {
    fun onPonenteClicked(ponente: Ponente, position: Int)
}