package com.auroraministudio.sehatqassignment.data.remote

import android.os.Parcelable
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
    val id: Long? = null,

    @SerializedName("imageUrl")
    val imageUrl: String? = null,

    @SerializedName("name")
    val name: String? = null
) : Parcelable


@Parcelize
data class Product(

    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("imageUrl")
    val imageUrl: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("desciption")
    val description: String? = null,

    @SerializedName("price")
    val price: String? = null,

    @SerializedName("loved")
    val loved: String? = null

) : Parcelable

