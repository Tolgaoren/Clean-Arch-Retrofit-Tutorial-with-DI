package com.toren.retrofittutorial.domain.repository

import com.toren.retrofittutorial.data.remote.dto.ProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductsDto

interface ProductRepository {

    suspend fun getProducts() : ProductsDto

    suspend fun  getProductById(productId: Int) : ProductDto

}