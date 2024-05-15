package com.toren.retrofittutorial.domain.repository

import com.toren.retrofittutorial.data.remote.dto.DeleteProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductsDto

interface ProductRepository {

    suspend fun getProducts(): ProductsDto

    suspend fun getProductById(productId: Int): ProductDto

    suspend fun addProduct(product: ProductDto): ProductDto

    suspend fun updateProduct(productId: Int, product: ProductDto): ProductDto

    suspend fun deleteProduct(productId: Int) : DeleteProductDto

}