package com.example.dam2_jetpreference

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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