package com.quansoft.quancast.features.login.data.remote

import com.google.gson.annotations.SerializedName

data class ApiKeyRequest(
    @SerializedName("api_key")
    val apiKey: String
)