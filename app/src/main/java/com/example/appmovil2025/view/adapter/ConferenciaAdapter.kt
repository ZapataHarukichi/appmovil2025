package com.example.appmovil2025.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.model.Conferencia

class ConferenciaAdapter(): RecyclerView.Adapter<ConferenciaAdapter.ViewHolder>() {
    var listadoConferencias = ArrayList<Conferencia>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ConferenciaAdapter.ViewHolder {
    }

    override fun onBindViewHolder(holder: ConferenciaAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount() = listadoConferencias.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}