package com.auroraministudio.sehatqassignment.feature.login

import android.os.Handler
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
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
    val openPageDashboard: LiveData<Boolean> get() = _openPageDashboard

    private val _loadingSignIn = MutableLiveData<Boolean>()
    val loadingSignIn: LiveData<Boolean> get() = _loadingSignIn

    private val _loadingSignInFacebok = MutableLiveData<Boolean>()
    val loadingSignInFacebook: LiveData<Boolean> get() = _loadingSignInFacebok

    private val _loadingSignInGoogle = MutableLiveData<Boolean>()
    val loadingSignInGoogle: LiveData<Boolean> get() = _loadingSignInGoogle

    private val _errorInputEmpty = MutableLiveData<String>()
    val errorInputEmpty: LiveData<String> get() = _errorInputEmpty

    fun signInEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            _errorInputEmpty.value = null
            _loadingSignIn.value = true
            Handler().postDelayed({
                _loadingSignIn.value = false
                _openPageDashboard.value = true
            }, 2000)
        } else {
            _errorInputEmpty.value = "Input for login still empty!"
        }
    }

    fun signInWithFacebook() {
        _loadingSignInFacebok.value = true
        Handler().postDelayed({
            _loadingSignInFacebok.value = false
            _openPageDashboard.value = true
        }, 2000)
    }

    fun signInWithGoogle() {
        _loadingSignInGoogle.value = true
        Handler().postDelayed({
            _loadingSignInGoogle.value = false
            _openPageDashboard.value = true
        }, 2000)
    }

}