package com.auroraministudio.sehatqassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
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
    val id: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: String
)

