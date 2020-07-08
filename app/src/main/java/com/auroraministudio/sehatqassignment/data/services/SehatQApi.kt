package com.auroraministudio.sehatqassignment.data.services

import com.auroraministudio.sehatqassignment.data.remote.Data
import com.auroraministudio.sehatqassignment.data.remote.HomeResponse
import retrofit2.http.GET

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
interface SehatQApi {

    @GET("home")
    suspend fun getDataHome(): List<HomeResponse>

}