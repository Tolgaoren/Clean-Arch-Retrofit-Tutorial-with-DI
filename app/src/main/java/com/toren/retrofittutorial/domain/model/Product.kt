package com.toren.retrofittutorial.domain.model

import com.toren.retrofittutorial.data.remote.dto.ProductDto

data class Product(
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
    val title: String,
)


fun Product.toProductDto(): ProductDto {
    return ProductDto(
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
