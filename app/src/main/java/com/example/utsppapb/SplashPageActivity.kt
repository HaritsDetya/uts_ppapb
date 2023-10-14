package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class SplashPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_page)
        Handler().postDelayed({
            startActivity(Intent(this@SplashPageActivity, LoginPageActivity::class.java))
            finish()
        }, 3000)
    }
}