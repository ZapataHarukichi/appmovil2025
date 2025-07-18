package com.example.appmovil2025.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Ponente
import com.bumptech.glide.Glide

class PonenteAdapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<PonenteAdapter.ViewHolder>() {
    var listadoPonentes = ArrayList<Ponente>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun onBindViewHolder(holder: PonenteAdapter.ViewHolder, position: Int) {
        val ponente = listadoPonentes[position] as Ponente

        Glide.with(holder.itemView.context)
            .load(ponente.imagen)
            .placeholder(R.drawable.logo_user)
            .into(holder.spkImage)
        holder.spkName.text = ponente.nombre
        holder.spkProfesion.text = ponente.profesion
        holder.spkTrabajo.text = ponente.trabajo

        holder.itemView.setOnClickListener {
            speakerListener.onPonenteClicked(ponente, position)
        }
    }

    override fun getItemCount() = listadoPonentes.size

    fun updateData(data: List<Ponente>){
        listadoPonentes.clear()
        listadoPonentes.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val spkImage = itemView.findViewById<ImageView>(R.id.imgSpeaker)
        val spkName = itemView.findViewById<TextView>(R.id.SpkName)
        val spkProfesion = itemView.findViewById<TextView>(R.id.SpkProfesion)
        val spkTrabajo = itemView.findViewById<TextView>(R.id.SpkTrabajo)
    }
}