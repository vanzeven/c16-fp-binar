package com.c16.flywithme.presentation.ui.user.booking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.c16.flywithme.R
import com.c16.flywithme.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.buttonPayment.setOnClickListener {
            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}