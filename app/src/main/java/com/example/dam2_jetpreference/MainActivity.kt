package com.example.dam2_jetpreference

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dam2_jetpreference.adapter.TaskAdapter
import com.example.dam2_jetpreference.databinding.ActivityMainBinding
import com.example.dam2_jetpreference.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TaskAdapter { task -> deleteConfirmation(task) }
        binding.rvTaskList.adapter = adapter
        binding.rvTaskList.layoutManager = LinearLayoutManager(this)

        viewModel.tasks.observe(this) { tasks ->
            adapter.updateTask(tasks)
        }

        binding.btnAddTask.setOnClickListener {
            val task = binding.etTaskInput.text.toString()
            if (!task.isNullOrBlank()) {
                viewModel.addTask(task)
                binding.etTaskInput.text.clear()
            }else{
                Toast.makeText(this, "Ingrese una tarea para ser agregada", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun deleteConfirmation(task: String){
        AlertDialog.Builder(this)
            .setTitle("Confirar borrado de tarea")
            .setMessage("Esta seguro de eliminar la tarea?")
            .setPositiveButton("Eliminar"){_,_ ->
                viewModel.removeTask(task)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}