package com.evergreen.app

import com.evergreen.app.api.LoginRequest
import com.evergreen.app.api.LoginResponse
import com.evergreen.app.api.NewUserResponse
import com.evergreen.app.api.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApíService {
    @GET("public/users/17")
    fun getUsers(): Call<User>

    @POST("/users")
    fun postUser(@Body post:User): Call<NewUserResponse>

    @POST("/users/authenticate")
    fun login(@Body login: LoginRequest): Call<LoginResponse>
}