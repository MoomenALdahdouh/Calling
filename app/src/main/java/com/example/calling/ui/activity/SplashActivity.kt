package com.example.calling.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.calling.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            /*if (PreferenceUtils.getName(this) != null && !PreferenceUtils.getName(
                    this
                ).equals("")
            ) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, IntroActivity::class.java))
            }*/
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }
}