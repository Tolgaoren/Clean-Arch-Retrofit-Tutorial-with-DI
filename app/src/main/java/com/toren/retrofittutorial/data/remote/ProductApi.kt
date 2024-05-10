package com.toren.retrofittutorial.data.remote

import com.toren.retrofittutorial.data.remote.dto.ProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : ProductsDto

    @GET("products/{id}")
    suspend fun  getProductById(@Path("id") productId: Int) : ProductDto

}