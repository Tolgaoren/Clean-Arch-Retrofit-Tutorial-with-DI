package com.toren.retrofittutorial.data.remote

import com.toren.retrofittutorial.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {


    @GET("products")
    suspend fun getProducts() : List<ProductDto>

    @GET("products/{id}")
    suspend fun  getProductById(@Path("id") productId: Int) : ProductDto

}