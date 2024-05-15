package com.toren.retrofittutorial.data.repository

import com.toren.retrofittutorial.data.remote.ProductApi
import com.toren.retrofittutorial.data.remote.dto.DeleteProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductsDto
import com.toren.retrofittutorial.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository{
    override suspend fun getProducts(): ProductsDto {
        return api.getProducts()
    }

    override suspend fun getProductById(productId: Int): ProductDto {
        return api.getProductById(productId)
    }

    override suspend fun addProduct(product: ProductDto) : ProductDto {
        return api.addProduct(product)
    }

    override suspend fun updateProduct(productId: Int, product: ProductDto): ProductDto {
        return api.updateProduct(productId, product)
    }

    override suspend fun deleteProduct(productId: Int) : DeleteProductDto {
        return api.deleteProduct(productId)
    }
}