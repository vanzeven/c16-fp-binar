package com.c16.flywithme.presentation.ui.start

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.MainActivity
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.databinding.ActivitySplashScreenBinding
import com.c16.flywithme.presentation.ui.user.home.HomeActivity
import com.c16.flywithme.presentation.ui.user.login.LoginActivity
import com.c16.flywithme.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var splashViewModel: SplashViewModel
    private var isLogin = false
    private var splashTime = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) toMain() else toLogin()
        }, splashTime)


        setViewModel()
    }

    private fun toLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        splashViewModel = ViewModelProvider(this, factory)[SplashViewModel::class.java]
        splashViewModel.getIsLogin().observe(this) {
            isLogin = it

        }
    }
}