package com.auroraministudio.sehatqassignment.data.remote

import android.os.Parcelable
import com.auroraministudio.sehatqassignment.data.local.entity.CategoryEntity
import com.auroraministudio.sehatqassignment.data.local.entity.ProductEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Parcelize
data class HomeResponse(
    @SerializedName("data")
    val data: Data? = null
) : Parcelable


@Parcelize
data class Data(
    @SerializedName("category")
    val categories: List<Category>? = null,

    @SerializedName("productPromo")
    val products: List<Product>? = null

) : Parcelable


@Parcelize
data class Category(
    @SerializedName("id")
    val id: Long,

    @SerializedName("imageUrl")
    val imageUrl: String? = null,

    @SerializedName("name")
    val name: String? = null
) : Parcelable


@Parcelize
data class Product(

    @SerializedName("id")
    val id: String,

    @SerializedName("imageUrl")
    val imageUrl: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("price")
    val price: String? = null,

    @SerializedName("loved")
    val loved: Int? = null

) : Parcelable

fun HomeResponse.asProductDatabaseModel() : List<ProductEntity> {
    return data?.products!!.map {
        ProductEntity(
            id = it.id,
            imageUrl = it.imageUrl ?: "",
            title = it.title ?: "",
            description = it.description ?: "",
            price = it.price ?: "",
            loved = it.loved ?: 0
        )
    }
}

fun HomeResponse.asCategoryDatabaseModel() : List<CategoryEntity> {
    return data?.categories!!.map {
        CategoryEntity(
            id = it.id,
            imageUrl = it.imageUrl ?: "",
            name = it.name ?: ""
        )
    }
}

