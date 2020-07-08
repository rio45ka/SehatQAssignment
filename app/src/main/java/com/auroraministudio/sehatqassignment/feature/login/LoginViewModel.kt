package com.auroraministudio.sehatqassignment.feature.login

import android.os.Handler
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@ExperimentalCoroutinesApi
class LoginViewModel @ViewModelInject constructor() : ViewModel() {

    private val _openPageDashboard = MutableLiveData<Boolean>()
    val openPageDashboard get() = _openPageDashboard

    private val _loadingSignIn = MutableLiveData<Boolean>()
    val loadingSignIn get() = _loadingSignIn

    private val _errorInputEmpty = MutableLiveData<String>()
    val errorInputEmpty get() = _errorInputEmpty

    fun signInEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            _errorInputEmpty.value = null
            _loadingSignIn.value = true
            Handler().postDelayed({
                _openPageDashboard.value = true
                _loadingSignIn.value = false
            }, 2000)
        } else {
            _errorInputEmpty.value = "Input for login still empty!"
        }
    }
}