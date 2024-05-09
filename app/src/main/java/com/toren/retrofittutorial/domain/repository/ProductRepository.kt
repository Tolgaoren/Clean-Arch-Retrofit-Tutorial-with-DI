package com.toren.retrofittutorial.domain.repository

import com.toren.retrofittutorial.data.remote.dto.ProductDto

interface ProductRepository {

    suspend fun getProducts() : List<ProductDto>

    suspend fun  getProductById(productId: Int) : ProductDto

}