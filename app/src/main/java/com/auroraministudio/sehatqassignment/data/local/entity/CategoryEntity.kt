package com.auroraministudio.sehatqassignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.auroraministudio.sehatqassignment.domain.model.Category
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Entity(tableName = Const.TABLE_CATEGORY)
data class CategoryEntity constructor(
    @PrimaryKey
    val id: Long,
    val imageUrl: String,
    val name: String
)

fun List<CategoryEntity>.asDomainModel(): List<Category> {
    return map {
        Category(
            id = it.id,
            imageUrl = it.imageUrl,
            name = it.name
        )
    }
}