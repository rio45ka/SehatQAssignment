package com.auroraministudio.sehatqassignment.di

import android.content.Context
import com.auroraministudio.sehatqassignment.data.local.SehatQDatabase
import com.auroraministudio.sehatqassignment.data.local.dao.CartDao
import com.auroraministudio.sehatqassignment.data.local.dao.CategoryDao
import com.auroraministudio.sehatqassignment.data.local.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): SehatQDatabase {
        return SehatQDatabase.getInstance(appContext)
    }

    @Singleton
    @Provides
    fun provideProductDao(database: SehatQDatabase): ProductDao {
        return database.productDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(database: SehatQDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Singleton
    @Provides
    fun provideCartDao(database: SehatQDatabase): CartDao {
        return database.cartDao()
    }
}