package com.auroraministudio.sehatqassignment.feature.home.data

import androidx.lifecycle.Transformations.map
import com.auroraministudio.sehatqassignment.data.local.dao.CategoryDao
import com.auroraministudio.sehatqassignment.data.local.dao.ProductDao
import com.auroraministudio.sehatqassignment.data.local.entity.asDomainModel
import com.auroraministudio.sehatqassignment.data.remote.asCategoryDatabaseModel
import com.auroraministudio.sehatqassignment.data.remote.asProductDatabaseModel
import com.auroraministudio.sehatqassignment.data.services.SehatQApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Singleton
class HomeRepository @Inject constructor(
    private val productDao: ProductDao,
    private val categoryDao: CategoryDao,
    private val service: SehatQApi
) {

    val products = map(productDao.getAllProduct()) { it.asDomainModel() }
    val categories = map(categoryDao.getAllCategory()) { it.asDomainModel() }

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            val response = service.getDataHome()
            productDao.saveAllProduct(response[0].asProductDatabaseModel())
            categoryDao.saveAllCategory(response[0].asCategoryDatabaseModel())
        }
    }
}