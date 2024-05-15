package com.toren.retrofittutorial.data.remote

import com.toren.retrofittutorial.data.remote.dto.DeleteProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductDto
import com.toren.retrofittutorial.data.remote.dto.ProductsDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : ProductsDto

    @GET("products/{id}")
    suspend fun  getProductById(@Path("id") productId: Int) : ProductDto

    @POST("products/add")
    @Headers("Content-Type: application/json")
    suspend fun addProduct(@Body product: ProductDto) : ProductDto

    @PUT("products/{id}")
    @Headers("Content-Type: application/json")
    suspend fun updateProduct(@Path("id") productId: Int, @Body product: ProductDto) : ProductDto

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int) : DeleteProductDto



}