package com.auroraministudio.sehatqassignment.feature.productdetail.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auroraministudio.sehatqassignment.domain.model.Product
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class DetailProductViewModel @ViewModelInject constructor() :
    ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    fun setData(item: Product) {
        viewModelScope.launch { _product.value = item }
    }
}