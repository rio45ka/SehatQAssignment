package com.auroraministudio.sehatqassignment.feature.search.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.feature.search.data.SearchRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class SearchViewModel @ViewModelInject constructor(private val repository: SearchRepository) :
    ViewModel() {

    private val _listProduct = MutableLiveData<List<Product>>()
    val listProduct get() = _listProduct

    private fun searchProduct(keyword: String) {
        viewModelScope.launch {
            _listProduct.value = repository.getSearchList(keyword)
        }
    }

    fun checkKeywordSearch(keyword: String) {
        if (keyword.isNotEmpty()) searchProduct(keyword)
    }
}