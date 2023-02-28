package com.example.ktorphilipplackner.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.ktorphilipplackner.databinding.ActivityMainBinding
import com.example.ktorphilipplackner.viewmodels.MainViewModel
import com.example.ktorphilipplackner.viewmodels.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModelFactory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.btnApiCall.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getPosts()
            }
        }

        viewModel.postList.observeForever {
            Log.d("MAVERICK",it.toString())
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }

    }
}