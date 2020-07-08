package com.auroraministudio.sehatqassignment.feature.dashboard.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.ActivityDashboardBinding
import androidx.core.os.postDelayed
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navController: NavController
    private var doubleTapExit = false

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, DashboardActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        setupViews()
    }

    private fun setupViews() {
        navController = findNavController(R.id.fragNavHost)
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (navController.graph.startDestination == navController.currentDestination?.id) {
            if (doubleTapExit) {
                super.onBackPressed()
                return
            }

            doubleTapExit = true
            Toast.makeText(this, R.string.msg_exit_double_tap, Toast.LENGTH_SHORT).show()

            Handler().postDelayed(2000) {
                doubleTapExit = false
            }
        } else {
            super.onBackPressed()
        }
    }
}