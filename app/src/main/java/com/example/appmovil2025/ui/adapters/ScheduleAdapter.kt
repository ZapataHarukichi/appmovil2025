package com.example.appmovil2025.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.R
import com.example.appmovil2025.ui.model.ScheduleItem

class ScheduleAdapter(private val scheduleList: List<ScheduleItem>):
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>(){

    class ScheduleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTime: TextView = itemView.findViewById(R.id.TVHora)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvSpeaker: TextView = itemView.findViewById(R.id.tvSpeaker)
        val tvTag: TextView = itemView.findViewById(R.id.tvTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = scheduleList[position]
        holder.tvTime.text = item.time
        holder.tvTitle.text = item.title
        holder.tvSpeaker.text = item.speaker
        holder.tvTag.text = item.tag
    }

    override fun getItemCount(): Int = scheduleList.size
}