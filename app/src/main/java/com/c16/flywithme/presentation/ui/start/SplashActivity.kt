package com.c16.flywithme.presentation.ui.start

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.databinding.ActivitySplashBinding
import com.c16.flywithme.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel
    private lateinit var user: UserLogin
    private var isLogin = false
    private val splashTime = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, GetStartActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)

        setViewModel()
        supportActionBar?.hide()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        viewModel = ViewModelProvider(this, factory)[SplashViewModel::class.java]
        viewModel.getUserData().observe(this) {
            isLogin = it.isLogin
            user = UserLogin(it.localid, it.email, it.password)
        }
    }
}