package com.example.dam2_jetpreference.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val onTaskClick: (String) -> Unit): RecyclerView.Adapter<TaskViewHolder>() {
    private var tasks: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return TaskViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = tasks[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{onTaskClick(item)}
    }

    fun updateTask(newTasks: List<String>){
        this.tasks = newTasks.toMutableList()
        notifyDataSetChanged()
    }
}