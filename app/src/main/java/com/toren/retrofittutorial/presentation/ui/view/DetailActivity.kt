package com.toren.retrofittutorial.presentation.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.toren.retrofittutorial.R
import com.toren.retrofittutorial.domain.model.Product
import com.toren.retrofittutorial.presentation.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observeLiveData()
        val product = Product("asd",
            "asd", "asd",
            1.1, 1, listOf<String>("asdasd"),
            1,1.2,1,"asd","dsaa")
        //viewModel.addProduct(product)
        viewModel.deleteProduct(1)
        //viewModel.getProduct(1)
        /*lifecycleScope.launch {
            viewModel.getFlowProduct(1).collect {product ->
                Toast.makeText(this@DetailActivity, product.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        */
    }

    private fun observeLiveData() {
        viewModel.product.observe(this) {
            it?.let {
                Toast.makeText(this,"$it", Toast.LENGTH_LONG).show()
            }
        }
    }
}