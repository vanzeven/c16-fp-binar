package com.c16.flywithme.presentation.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.c16.flywithme.R
import com.c16.flywithme.presentation.ui.user.login.LoginActivity

class GetStartActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start)

       val btnGetStart: Button = findViewById(R.id.btn_getstart)
        btnGetStart.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_getstart -> {
                val intent = Intent(this@GetStartActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}