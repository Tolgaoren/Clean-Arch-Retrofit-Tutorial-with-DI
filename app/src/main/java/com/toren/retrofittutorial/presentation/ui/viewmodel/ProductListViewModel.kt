package com.toren.retrofittutorial.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.retrofittutorial.common.Resource
import com.toren.retrofittutorial.domain.use_case.get_products.GetProductsUseCase
import com.toren.retrofittutorial.presentation.ui.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel
    @Inject constructor(
        private val getProductsUseCase: GetProductsUseCase,
    ) : ViewModel() {

    private val _products = MutableLiveData<ProductListState>(ProductListState())
    val products: LiveData<ProductListState> = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _products.value = ProductListState(
                        products = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _products.value = ProductListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _products.value = ProductListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}