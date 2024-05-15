package com.toren.retrofittutorial.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.retrofittutorial.data.remote.dto.toProduct
import com.toren.retrofittutorial.domain.model.Product
import com.toren.retrofittutorial.domain.model.toProductDto
import com.toren.retrofittutorial.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ProductRepository,
) : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    /*
    fun getProduct(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getProductById(id)
            data.let {
                launch(Dispatchers.Main) {
                _product.value = it.toProduct()
                     }
            }
        }
    }

    fun getFlowProduct(id: Int) : Flow<Product> = flow {
        try {
            val data = repository.getProductById(id)
            data.let {
                emit(it.toProduct())
            }
        } catch (e: Exception) {
            Log.d("viewmodel", "fail")
        }
    }
*/
    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.addProduct(product.toProductDto())
            data.let {
                launch(Dispatchers.Main) {
                    _product.value = it.toProduct()
                }
            }
        }
    }

    fun updateProduct(id: Int, product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.updateProduct(id, product.toProductDto())
            data.let {
                launch(Dispatchers.Main) {
                    _product.value = it.toProduct()
                }

            }
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.deleteProduct(id)
            data.let {
                launch(Dispatchers.Main) {
                    println(data.isDeleted)
                }
            }
        }
    }
}