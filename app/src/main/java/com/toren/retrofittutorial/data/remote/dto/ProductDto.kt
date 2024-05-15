package com.toren.retrofittutorial.data.remote.dto

import com.toren.retrofittutorial.domain.model.Product

data class ProductDto(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)

fun ProductDto.toProduct() : Product {
    return Product(
        // lazım olmay  anları çıkaracağım
        brand,
        category,
        description,
        discountPercentage,
        id,
        images,
        price,
        rating,
        stock,
        thumbnail,
        title
    )
}