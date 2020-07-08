package com.auroraministudio.sehatqassignment.feature.login

import android.os.Handler
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class LoginViewModel @ViewModelInject constructor() : ViewModel() {

    private val _openPageHome = MutableLiveData<Boolean>()
    val openPageHome get() = _openPageHome

    private val _loadingSignIn = MutableLiveData<Boolean>()
    val loadingSignIn get() = _loadingSignIn

    fun signIn() {
        Handler().postDelayed({ _openPageHome.value = true }, 2000)
    }
}