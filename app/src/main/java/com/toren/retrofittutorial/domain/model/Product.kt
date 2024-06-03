package com.toren.retrofittutorial.domain.model

import android.os.Parcelable
import com.toren.retrofittutorial.data.remote.dto.Review
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product( // Product detail
    val availabilityStatus: String,
    val brand: String?,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val reviews: List<Review>,
    val shippingInformation: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
) : Parcelable
