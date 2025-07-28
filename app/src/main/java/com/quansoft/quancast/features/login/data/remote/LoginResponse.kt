package com.quansoft.quancast.features.login.data.remote

data class LoginResponse(
    val token: String,
    val userId: String,
    val username: String,
    val email: String,
    val isAdmin: Boolean
)