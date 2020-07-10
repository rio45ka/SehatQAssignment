package com.auroraministudio.sehatqassignment.feature.search.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
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
    val listProduct: LiveData<List<Product>> get() = _listProduct

    private val _navigateToSelectedProduct = MutableLiveData<Product>()
    val navigateToSelectedProduct: LiveData<Product> get() = _navigateToSelectedProduct

    private fun searchProduct(keyword: String) {
        viewModelScope.launch {
            _listProduct.value = repository.getSearchList(keyword)
        }
    }

    fun checkKeywordSearch(keyword: String) {
        if (keyword.isNotEmpty()) searchProduct(keyword)
    }

    fun displayProductDetail(product: Product) {
        _navigateToSelectedProduct.value = product
    }

    fun displayCompleteProductDetail() {
        _navigateToSelectedProduct.value = null
    }
}