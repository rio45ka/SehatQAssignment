package com.auroraministudio.sehatqassignment.domain.repository

import com.auroraministudio.sehatqassignment.domain.model.HomeData

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
interface HomeRepository {
    suspend fun getDataHome(): HomeData
}