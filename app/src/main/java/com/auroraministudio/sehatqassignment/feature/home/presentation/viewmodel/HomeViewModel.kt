package com.auroraministudio.sehatqassignment.feature.home.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auroraministudio.sehatqassignment.feature.home.data.HomeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class HomeViewModel @ViewModelInject constructor(private val repository: HomeRepository) :
    ViewModel() {

    val listProduct = repository.products
    val listCategory = repository.categories

    private val _errorFetchData = MutableLiveData<String>()
    val errorFetchData get() = _errorFetchData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                repository.refreshData()
            } catch (e: Exception) {
                _errorFetchData.value = e.message
            }
        }
    }
}