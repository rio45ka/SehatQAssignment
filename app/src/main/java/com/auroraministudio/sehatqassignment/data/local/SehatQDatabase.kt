package com.auroraministudio.sehatqassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.auroraministudio.sehatqassignment.data.local.dao.CartDao
import com.auroraministudio.sehatqassignment.data.local.dao.CategoryDao
import com.auroraministudio.sehatqassignment.data.local.dao.ProductDao
import com.auroraministudio.sehatqassignment.data.local.entity.CartEntity
import com.auroraministudio.sehatqassignment.data.local.entity.CategoryEntity
import com.auroraministudio.sehatqassignment.data.local.entity.ProductEntity
import com.auroraministudio.sehatqassignment.utils.Const

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Database(
    entities = [ProductEntity::class, CategoryEntity::class, CartEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SehatQDatabase : RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: SehatQDatabase? = null

        fun getInstance(context: Context): SehatQDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SehatQDatabase::class.java,
                    Const.DATABASE_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao
    abstract fun cartDao(): CartDao
}