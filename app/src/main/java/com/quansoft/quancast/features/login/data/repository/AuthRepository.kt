package com.quansoft.quancast.features.login.data.repository

import com.quansoft.quancast.core.util.Resource
import com.quansoft.quancast.features.login.data.remote.ApiKeyRequest
import com.quansoft.quancast.features.login.data.remote.DevicesResponse
import com.quansoft.quancast.features.login.data.remote.LoginResponse

interface AuthRepository {
    suspend fun login(token: ApiKeyRequest): Resource<LoginResponse>
    /**
     * Checks if the user is authenticated.
     * @return true if the user is authenticated, false otherwise.
     */
    suspend fun isAuthenticated(): Boolean
    suspend fun getDevices(request: ApiKeyRequest): Resource<DevicesResponse>
}