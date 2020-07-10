package com.auroraministudio.sehatqassignment.feature.productdetail.data

import com.auroraministudio.sehatqassignment.data.local.dao.CartDao
import com.auroraministudio.sehatqassignment.data.local.entity.CartEntity
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.utils.getTimeNow
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
class DetailProductRepository @Inject constructor(
    private val cartDao: CartDao
) {

    suspend fun actionBuyProduct(product: Product) {
        withContext(Dispatchers.IO) {
            val cart = CartEntity(
                id = product.id,
                imageUrl = product.imageUrl,
                title = product.title,
                description = product.description,
                price = product.price,
                date = getTimeNow()
            )
            cartDao.saveProduct(cart)
        }
    }
}