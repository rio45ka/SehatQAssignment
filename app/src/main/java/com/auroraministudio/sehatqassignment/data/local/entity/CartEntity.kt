package com.auroraministudio.sehatqassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.auroraministudio.sehatqassignment.domain.model.Cart
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Entity(tableName = Const.TABLE_CART)
data class CartEntity constructor(
    @PrimaryKey
    val date: String,
    val id: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: String
)

fun List<CartEntity>.asDomainModel(): List<Cart> {
    return map {
        Cart(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            description = it.description,
            price = it.price,
            date = it.date
        )
    }
}

