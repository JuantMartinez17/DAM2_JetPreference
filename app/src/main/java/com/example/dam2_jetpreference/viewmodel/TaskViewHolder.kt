package com.example.dam2_jetpreference.viewmodel

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskItem: TextView = itemView.findViewById(android.R.id.text1)
    fun bind (task: String){
        taskItem.text = task
    }
}