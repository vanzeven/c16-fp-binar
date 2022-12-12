package com.c16.flywithme.presentation.ui.user.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.R
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.remote.LoginRequest
import com.c16.flywithme.data.response.LoginResponse
import com.c16.flywithme.viewmodel.ViewModelFactory
import com.c16.flywithme.data.result.Result
import com.c16.flywithme.data.user.model.UserLogin
import com.c16.flywithme.databinding.ActivityLoginBinding
import com.c16.flywithme.databinding.DialogLoadingBinding
import com.c16.flywithme.presentation.ui.user.home.HomeActivity
import com.c16.flywithme.presentation.ui.user.register.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()

        binding.btnLogin.setOnClickListener{
            loginAction()
        }

        binding.btnRegister.setOnClickListener{
            toRegister()
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }


    private fun loginAction() {
        val emailEditText = binding.etEmail
        val passwordEditText = binding.etPassword

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

//        val req = LoginRequest(email, password)
//        req.email = email.trim()
//        req.password = password.trim()

//        val retro = ApiConfig.getApiService()
//        retro.loginUser(req).enqueue(object : Callback<LoginResponse>{
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                try {
//                    if (response.body()?.status == false){
//                        val data = UserLogin(
//                            response.body()?.`data?.id,
//                            response.body()?.data?.email,
//                            response.body()?.data?.password,
//                        )
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                Log.e("Error", t.message.toString())
//            }
//
//        })

        when {
            email.isEmpty() -> emailEditText.error = resources.getString(R.string.empty_email)
            !checkEmailError(email) -> emailEditText.error = resources.getString(R.string.not_email)
            password.isEmpty() -> passwordEditText.error = resources.getString(R.string.empty_pass)
            password.length < 6 -> passwordEditText.error =
                resources.getString(R.string.pass_less_than_six)
            else -> {
                //loading dialog
                val customBind = DialogLoadingBinding.inflate(layoutInflater)
                val loadingDialogBuilder = AlertDialog.Builder(this).apply {
                    setView(customBind.root)
                    setCancelable(false)
                }
                val loadingDialog = loadingDialogBuilder.create()

                viewModel.loginUser(email, password).observe(this) { result ->
                    when (result) {
                        is Result.Loading -> loadingDialog.show()
                        is Result.Success -> {
                            loadingDialog.dismiss()
                            //viewModel.saveUser(result.data)
                            toMain()
                        }
                        is Result.Error -> {
                            loadingDialog.dismiss()
                            errorAlert(result.error)
                        }
                    }
                }
            }

        }


    }

    private fun checkEmailError(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) false else android.util.Patterns.EMAIL_ADDRESS.matcher(
            target
        ).matches()
    }

    private fun errorAlert(message: String) {
        AlertDialog.Builder(this).apply {
            setTitle(resources.getString(R.string.failed_login))
            setMessage(message)
            create()
            show()
        }
    }

    private fun toMain() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun toRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}
