package com.quansoft.quancast.features.login.data.remote

import com.google.gson.annotations.SerializedName

data class DevicesResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val devices: List<Device>
)