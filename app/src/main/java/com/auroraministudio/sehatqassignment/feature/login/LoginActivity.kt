package com.auroraministudio.sehatqassignment.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.ActivityLoginBinding
import com.auroraministudio.sehatqassignment.utils.setFromHtmlTv

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var doubleTapExit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Fullscreen)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupUi()
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
}