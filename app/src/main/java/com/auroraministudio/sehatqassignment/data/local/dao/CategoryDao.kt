package com.auroraministudio.sehatqassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.auroraministudio.sehatqassignment.data.local.entity.CategoryEntity
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCategory(category: CategoryEntity)

    @Query("SELECT * FROM ${Const.TABLE_CATEGORY}")
    suspend fun getAllCategory() : List<CategoryEntity>
}