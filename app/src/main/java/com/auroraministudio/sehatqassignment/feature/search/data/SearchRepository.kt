package com.auroraministudio.sehatqassignment.feature.search.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.utils.SampleData
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Singleton
class SearchRepository @Inject constructor() {

    @SuppressLint("DefaultLocale")
    fun getSearchList(keyword: String): List<Product> {
        return SampleData().product.filter { it.title.toLowerCase().contains(keyword) }
    }
}