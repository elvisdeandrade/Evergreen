package com.evergreen.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro)

        val cancelaCadastro = findViewById<ImageView>(R.id.cancelaCadastro)

        cancelaCadastro.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }
    }
}