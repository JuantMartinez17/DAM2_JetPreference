package com.example.dam2_jetpreference.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val sharedPreferences: SharedPreferences = application.getSharedPreferences("tasks_pref", Context.MODE_PRIVATE)
    private val _tasks: MutableLiveData<MutableList<String>> = MutableLiveData(mutableListOf())
    val tasks: LiveData<MutableList<String>> = _tasks

    init {
        loadTasks()
    }

    fun loadTasks(){
        val savedTasks = sharedPreferences.getStringSet("tasks", emptySet())?: emptySet()
        _tasks.value = savedTasks.toMutableList()
    }

    fun addTask(task: String){
        val currentTask = _tasks.value ?: mutableListOf()
        currentTask.add(task)
        sharedPreferences.edit().putStringSet("tasks", currentTask.toSet()).apply()
        _tasks.value = currentTask
    }

    fun removeTask(task:String){
        val currentTask = _tasks.value?: mutableListOf()
        currentTask.remove(task)
        sharedPreferences.edit().putStringSet("tasks", currentTask.toSet()).apply()
        _tasks.value = currentTask
    }

}
