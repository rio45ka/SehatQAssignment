package com.auroraministudio.sehatqassignment.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.auroraministudio.sehatqassignment.data.local.entity.CartEntity
import com.auroraministudio.sehatqassignment.data.local.entity.ProductEntity
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProduct(product: CartEntity)

    @Query("DELETE FROM ${Const.TABLE_CART}")
    fun clearCart()

    @Query("SELECT * FROM ${Const.TABLE_CART}")
    fun getAllProductCart(): LiveData<List<CartEntity>>
}