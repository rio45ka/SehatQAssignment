package com.auroraministudio.sehatqassignment.feature.productdetail.presentation.viewmodel

import android.os.Handler
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.feature.productdetail.data.DetailProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class DetailProductViewModel @ViewModelInject constructor(private val repository: DetailProductRepository) :
    ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    private val _hasLikeProduct = MutableLiveData(0)
    val hasLikeProduct: LiveData<Int> get() = _hasLikeProduct

    private val _showAnimLikeProduct = MutableLiveData<Boolean>()
    val showAnimLikeProduct: LiveData<Boolean> get() = _showAnimLikeProduct

    private val _successBuyProduct = MutableLiveData<Boolean>()
    val successBuyProduct : LiveData<Boolean> get() = _successBuyProduct

    fun setData(item: Product) {
        viewModelScope.launch { _product.value = item }
    }

    fun actionAddLovedProduct() {
        _showAnimLikeProduct.value = true
        Handler().postDelayed({
            _showAnimLikeProduct.value = false
            _hasLikeProduct.value = 1
        }, 1000)
    }

    fun actionRemovedLoveProduct() {
        _hasLikeProduct.value = 0
    }

    fun actionBuyProduct(product: Product) {
        viewModelScope.launch {
            repository.actionBuyProduct(product)
            _successBuyProduct.value = true
        }
    }
}