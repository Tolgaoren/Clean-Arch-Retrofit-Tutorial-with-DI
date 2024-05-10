package com.toren.retrofittutorial.di

import com.toren.retrofittutorial.common.Constants
import com.toren.retrofittutorial.data.remote.ProductApi
import com.toren.retrofittutorial.data.repository.ProductRepositoryImpl
import com.toren.retrofittutorial.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductApi() : ProductApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi) : ProductRepository {
        return ProductRepositoryImpl(api)
    }
}