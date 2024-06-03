package com.toren.retrofittutorial.domain.model

import com.toren.retrofittutorial.domain.model.Product

data class ProductListState(
    val isLoading : Boolean = false,
    val products : List<Product> = emptyList(),
    val error : String = ""
)
