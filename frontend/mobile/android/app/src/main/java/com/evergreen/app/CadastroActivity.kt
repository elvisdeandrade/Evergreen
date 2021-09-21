package com.evergreen.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.evergreen.app.api.NewUserResponse
import com.evergreen.app.api.User
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

const val BASE_URL = "http://192.168.0.27:8080/"
const val TAG = "CadastroActivity"
class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro)

        val cancelaCadastro = findViewById<ImageView>(R.id.cancelaCadastro)
        val btnCadastrar =  findViewById<Button>(R.id.btnCadastrarUsuario)

        cancelaCadastro.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

        btnCadastrar.setOnClickListener{
            val txtNome = findViewById<TextInputEditText>(R.id.txtNome)
            val txtEmail = findViewById<TextInputEditText>(R.id.layoutEmail)
            val txtSenha = findViewById<TextInputEditText>(R.id.layoutSenha)
            val txtCelular = findViewById<TextInputEditText>(R.id.txtCelular)

            val nome = txtNome.text.toString()
            val email = txtEmail.text.toString()
            val senha = txtSenha.text.toString()
            val celular = txtCelular.text.toString()

            if(nome.isEmpty()){
                txtNome.setError("O campo nome é obrigatório")
                return@setOnClickListener
            }

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

            if(celular.isEmpty()){
                txtCelular.setError("O campo celular é obrigatório")
                return@setOnClickListener
            }

            val user = User(
                nome,
                email,
                "1970-06-26",
                "Male",
                celular,
                senha
            )

            saveUser(user)
        }
    }

    private fun saveUser(u:User){
        try {
            val api:ApíService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApíService::class.java )

            val response = api.postUser(u)

            response.enqueue(object: Callback<NewUserResponse> {
                override fun onResponse(
                    call: Call<NewUserResponse>,
                    response: Response<NewUserResponse>
                ) {
                   if(response?.body() != null){
                        val data = response.body()!!

                        Log.d(TAG, data.message)

                       if(data.success) {
                           Toast.makeText(baseContext, data.message, Toast.LENGTH_SHORT).show()
                           this@CadastroActivity.finish()
                       }
                    }
                }

                override fun onFailure(call: Call<NewUserResponse>?, t: Throwable?) {
                    Log.d(TAG, t?.message.toString())

                    Toast.makeText(baseContext, "Ops! Parece que algo deu errado. Tente novamente mais tarde.", Toast.LENGTH_SHORT).show()
                }
            })
        } catch (ex: Exception){
            ex.message?.let { Log.d(TAG, it) }
            Log.d(TAG, "putz")
        }
    }
}