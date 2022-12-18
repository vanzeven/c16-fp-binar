package com.c16.flywithme.presentation.ui.user.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.c16.flywithme.databinding.ActivityRegisterBinding
import com.c16.flywithme.databinding.DialogLoadingBinding
import com.c16.flywithme.data.result.Result
import com.c16.flywithme.presentation.ui.user.login.LoginActivity
import com.c16.flywithme.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
//    private val genderItems = listOf("Male", "Female")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerAction()
        setViewModel()

        binding.btnRegister.setOnClickListener{
            registerAction()
        }
    }

    private fun registerAction(){
        val emailEditText = binding.etEmail
        val firstNameEditText = binding.etFirstName
        val lastNameEditText = binding.etLastName
        val nIKEditText = binding.etNik
        val passwordEditText = binding.etPassword
        val phoneNumberEditText = binding.etPhone
        //val genderEditText = binding.genderField
//        val phoneEditText = binding.etPhone
//        val nikEditText = binding.etNik

        val email = emailEditText.text.toString()
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val password = passwordEditText.text.toString()
//        val conPassword = confirmPasswordEditText.text.toString()
        //val gender = genderEditText.editText?.text.toString()
        //val genderValue = if (gender == genderItems[0]) "M" else "F"
        val phone = phoneNumberEditText.text.toString()
        val nik = nIKEditText.text.toString()

        when {
            email.isEmpty() -> emailEditText.error = "Email is required"
            !checkEmailError(email) -> emailEditText.error = "Email is not valid"
            firstName.isEmpty() -> firstNameEditText.error = "First Name is required"
            lastName.isEmpty() -> lastNameEditText.error = "Last Name is required"
            nik.isEmpty() -> nIKEditText.error = "NIK is required"
            password.isEmpty() -> passwordEditText.error = "Password is required"
            password.length < 6 -> passwordEditText.error = "Password must be at least 6 characters"
            phone.isEmpty() -> phoneNumberEditText.error = "Phone Number is required"
            phone.length < 11 -> phoneNumberEditText.error = "Phone Number must be at least 11 characters"
//            conPassword.isEmpty() -> confirmPasswordEditText.error = "Confirm Password is required"
//            conPassword.length < 6 -> confirmPasswordEditText.error = "Confirm Password must be at least 6 characters"
//            password != conPassword -> confirmPasswordEditText.error = "Password and Confirm Password must be same"

            else -> {
                val customBind = DialogLoadingBinding.inflate(layoutInflater)
                val loadingDialogBuilder = AlertDialog.Builder(this).apply {
                    setView(customBind.root)
                    setCancelable(false)
                }
                val loadingDialog = loadingDialogBuilder.create()

                viewModel.registerUser(email, firstName, lastName, 0, password, phone)
                    .observe(this) { result ->
                        when (result) {
                            is Result.Loading -> loadingDialog.show()
                            is Result.Success -> {
                                loadingDialog.dismiss()
                                Toast.makeText(
                                    this, "Register Success",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                toLogin()
                            }
                            is Result.Error -> {
                                loadingDialog.dismiss()
                                Toast.makeText(
                                    this, "Register Failed",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                    }
            }
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(this, dataStore)
        viewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]
    }

    private fun checkEmailError(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) false else android.util.Patterns.EMAIL_ADDRESS.matcher(
            target
        ).matches()
    }

    private fun toLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}