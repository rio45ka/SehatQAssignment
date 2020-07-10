package com.auroraministudio.sehatqassignment.feature.profile.data

import androidx.lifecycle.Transformations.map
import com.auroraministudio.sehatqassignment.data.local.dao.CartDao
import com.auroraministudio.sehatqassignment.data.local.entity.asDomainModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by Rio on 10/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Singleton
class ProfileRepository @Inject constructor(private val cartDao: CartDao) {

    val products = map(cartDao.getAllProductCart()) { it.asDomainModel() }
}