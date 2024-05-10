package com.toren.retrofittutorial.domain.use_case.get_product

import com.toren.retrofittutorial.common.Resource
import com.toren.retrofittutorial.data.remote.dto.toProduct
import com.toren.retrofittutorial.domain.model.Product
import com.toren.retrofittutorial.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository,
) {

    operator fun invoke(id : Int): Flow<Resource<Product>> = flow {
        try {
            emit(Resource.Loading<Product>())
            val product = repository.getProductById(id).toProduct()
            emit(Resource.Success<Product>(product))
        } catch (e: HttpException) {
            emit(Resource.Error<Product>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<Product>(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }

}