package com.evergreen.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.Window.*
import android.content.Intent
import android.widget.ImageView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        val loginBackButton = findViewById<ImageView>(R.id.loginBackButton)

        loginBackButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }
    }
}