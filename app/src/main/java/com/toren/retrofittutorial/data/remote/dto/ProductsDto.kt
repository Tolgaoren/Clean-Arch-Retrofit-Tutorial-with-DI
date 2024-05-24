package com.toren.retrofittutorial.data.remote.dto

import com.toren.retrofittutorial.domain.model.Product

data class ProductsDto(
    val limit: Int,
    val products: List<ProductDto>,
    val skip: Int,
    val total: Int
)




fun ProductsDto.toProductList(): List<Product> {
    return products.map { it.toProduct() }
}