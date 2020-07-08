package com.auroraministudio.sehatqassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.auroraministudio.sehatqassignment.data.local.entity.CategoryEntity
import com.auroraministudio.sehatqassignment.data.local.entity.ProductEntity
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProduct(product: ProductEntity)

    @Query("SELECT * FROM ${Const.TABLE_PRODUCT}")
    suspend fun getAllProduct(): List<ProductEntity>
}