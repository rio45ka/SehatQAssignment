package com.auroraministudio.sehatqassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.auroraministudio.sehatqassignment.data.remote.Product
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Entity(tableName = Const.TABLE_PRODUCT)
data class ProductEntity constructor(
    @PrimaryKey
    val id: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: String,
    val loved: Int
)

fun List<ProductEntity>.asDomainModel(): List<Product> {
    return map {
        Product(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            description = it.description,
            price = it.price,
            loved = it.loved
        )
    }
}