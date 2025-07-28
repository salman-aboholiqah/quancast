package com.quansoft.quancast.features.login.data.remote


import com.google.gson.annotations.SerializedName


data class Device(
    @SerializedName("id")
    val id: String,

    @SerializedName("number")
    val number: String?, // قد يكون null

    @SerializedName("account_id")
    val accountId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("token")
    val token: String,

    @SerializedName("status")
    val status: String
)