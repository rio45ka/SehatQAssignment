package com.auroraministudio.sehatqassignment.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.ActivityLoginBinding
import com.auroraministudio.sehatqassignment.feature.dashboard.view.DashboardActivity
import com.auroraministudio.sehatqassignment.utils.getTextFromInput
import com.auroraministudio.sehatqassignment.utils.hideKeyboard
import com.auroraministudio.sehatqassignment.utils.setFromHtmlTv
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding
    private var doubleTapExit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Fullscreen)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = loginViewModel

        setupUi()
        setupClick()
        setupObserver()
    }

    override fun onBackPressed() {
        if (doubleTapExit) {
            super.onBackPressed()
            return
        }
        this.doubleTapExit = true
        Toast.makeText(this, R.string.msg_exit_double_tap, Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleTapExit = false }, 2000)
    }

    private fun setupUi() {
        setFromHtmlTv(
            "New here? <b><font color='#4FA0A0'>Create an account</font></b>",
            binding.tvActionRegister
        )
    }

    private fun setupClick() {
        binding.btnLogin.setOnClickListener {
            hideKeyboard()
            loginViewModel.signInEmail(
                getTextFromInput(binding.etUsernameLogin),
                getTextFromInput(binding.inputPasswordLogin)
            )
        }
    }

    private fun setupObserver() {
        loginViewModel.errorInputEmpty.observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        loginViewModel.openPageDashboard.observe(this, Observer {
            if (it != null || it == true) openDashboardPage()
        })
    }

    private fun openDashboardPage() {
        DashboardActivity.start(this)
        finish()
    }
}