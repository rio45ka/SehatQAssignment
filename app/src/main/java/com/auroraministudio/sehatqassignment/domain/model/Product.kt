package com.auroraministudio.sehatqassignment.domain.model

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
data class Product(
    val id: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: String,
    val loved: Int
)