package com.example.appmovil2025.view.adapter

import androidx.constraintlayout.motion.widget.KeyPosition
import com.example.appmovil2025.model.Conferencia

interface ScheduleListener {
    fun onConferenciaClicked(conferencia: Conferencia, position: Int)
}