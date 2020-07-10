package com.auroraministudio.sehatqassignment.feature.profile.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auroraministudio.sehatqassignment.domain.model.Cart
import com.auroraministudio.sehatqassignment.feature.profile.data.ProfileRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 *
 * Created by Rio on 10/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class ProfileViewModel @ViewModelInject constructor(private val repository: ProfileRepository) :
    ViewModel() {

    val listProduct = repository.products

    private val _navigateToSelectedProduct = MutableLiveData<Cart>()
    val navigateToSelectedProduct: LiveData<Cart> get() = _navigateToSelectedProduct

    fun displayProductDetail(product: Cart) {
        _navigateToSelectedProduct.value = product
    }

    fun displayCompleteProductDetail() {
        _navigateToSelectedProduct.value = null
    }
}