package com.example.appmovil2025.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Conferencia
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ConferenciaAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ConferenciaAdapter.ViewHolder>() {
    var listadoConferencias = ArrayList<Conferencia>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun onBindViewHolder(holder: ConferenciaAdapter.ViewHolder, position: Int) {
        val conferencia = listadoConferencias[position]

        holder.tvTituloConferencia.text = conferencia.titulo

        val simpleDateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val horarioFormato = simpleDateFormat.format(conferencia.horafecha)
        holder.tvHoraConferencia.text = horarioFormato

        holder.tvExpositor.text = conferencia.expositor
        holder.tvTopic.text = conferencia.topico

        holder.itemView.setOnClickListener {
            scheduleListener.onConferenciaClicked(conferencia, position)
        }
    }


    override fun getItemCount() = listadoConferencias.size

    fun updateData(data: List<Conferencia>){
        listadoConferencias.clear()
        listadoConferencias.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTituloConferencia = itemView.findViewById<TextView>(R.id.TvItemScheduleTitle)
        val tvHoraConferencia = itemView.findViewById<TextView>(R.id.TvItemScheduleHora)
        val tvExpositor = itemView.findViewById<TextView>(R.id.TvItemScheduleSpeaker)
        val tvTopic = itemView.findViewById<TextView>(R.id.TvItemScheduleTopic)
    }
}