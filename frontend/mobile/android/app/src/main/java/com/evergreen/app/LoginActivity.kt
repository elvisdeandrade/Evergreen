package com.evergreen.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.evergreen.app.api.LoginRequest
import com.evergreen.app.api.LoginResponse
import com.evergreen.app.api.NewUserResponse
import com.evergreen.app.api.User
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        val loginBackButton = findViewById<ImageView>(R.id.loginBackButton)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        loginBackButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val txtEmail = findViewById<TextInputEditText>(R.id.txtEmail)
            val txtSenha = findViewById<TextInputEditText>(R.id.txtSenha)

            val email = txtEmail.text.toString()
            val senha = txtSenha.text.toString()

            if(email.isEmpty()){
                txtEmail.setError("O campo email é obrigatório")

                return@setOnClickListener
            }

            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                txtEmail.setError("E-mail inválido")
                return@setOnClickListener
            }

            if(senha.isEmpty()){
                txtSenha.setError("O campo senha é obrigatório")
                return@setOnClickListener
            }

            login(email,senha)
        }
    }

    private fun login(username:String, password:String){
        try {
            val api:ApíService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApíService::class.java )

            val login:LoginRequest = LoginRequest(username,password)
            val response = api.login(login)

            response.enqueue(object: Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if(response?.body() != null){
                        val data = response.body()!!

                        Log.d(TAG, data.jwt)

                        if(data.success) {
                            Toast.makeText(baseContext, data.jwt, Toast.LENGTH_SHORT).show()
                            //this@CadastroActivity.finish()
                        }
                        else {
                            Toast.makeText(baseContext, "Usuario e/ou senha inválidos", Toast.LENGTH_SHORT).show()
                        }

                    }
                }

                override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                    Log.d(TAG, t?.message.toString())

                    Toast.makeText(baseContext, "Usuario e/ou senha inválidos", Toast.LENGTH_SHORT).show()
                }
            })
        } catch (ex: Exception){
            ex.message?.let { Log.d(TAG, it) }
            Log.d(TAG, "putz")
        }
    }
}