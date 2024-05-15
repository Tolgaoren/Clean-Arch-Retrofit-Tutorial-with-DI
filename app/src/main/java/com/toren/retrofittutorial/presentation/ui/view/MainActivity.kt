package com.toren.retrofittutorial.presentation.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.toren.retrofittutorial.BuildConfig
import com.toren.retrofittutorial.R
import com.toren.retrofittutorial.databinding.ActivityMainBinding
import com.toren.retrofittutorial.presentation.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeData()

        val a = BuildConfig.API_KEY
        println(a)

        binding.button.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("id", 1)
            startActivity(i)
        }
    }

    private fun observeData() {
        viewModel.products.observe(this) {
            println(it)
        }
    }
}