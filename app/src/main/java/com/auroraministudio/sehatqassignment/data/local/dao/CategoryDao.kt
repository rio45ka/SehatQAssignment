package com.auroraministudio.sehatqassignment.data.local.dao

import androidx.lifecycle.LiveData
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
    fun saveAllCategory(category: List<CategoryEntity>)

    @Query("SELECT * FROM ${Const.TABLE_CATEGORY}")
    fun getAllCategory() : LiveData<List<CategoryEntity>>
}