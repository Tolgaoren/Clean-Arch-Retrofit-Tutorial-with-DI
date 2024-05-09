package com.toren.retrofittutorial.domain.use_case.get_products

import com.toren.retrofittutorial.common.Resource
import com.toren.retrofittutorial.data.remote.dto.toProduct
import com.toren.retrofittutorial.domain.model.Product
import com.toren.retrofittutorial.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository,
) {

    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProducts().map {it.toProduct()}
            emit(Resource.Success(products))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }

}