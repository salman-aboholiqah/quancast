package com.quansoft.quancast.features.login.data.repository

import com.quansoft.quancast.core.util.Resource
import com.quansoft.quancast.features.login.data.remote.ApiKeyRequest
import com.quansoft.quancast.features.login.data.remote.AuthApiService
import com.quansoft.quancast.features.login.data.remote.DevicesResponse
import com.quansoft.quancast.features.login.data.remote.LoginResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: AuthApiService
) : AuthRepository {
    override suspend fun login(token: ApiKeyRequest): Resource<LoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun isAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getDevices(request: ApiKeyRequest): Resource<DevicesResponse> {
        return try {
            val response = apiService.getDevices(request)
            if (response.isSuccessful) {
                // If the network call was successful, return the data.
                response.body()?.let { result ->
                    Resource.Success(result)
                } ?: Resource.Error("An unknown error occurred: Response body is null.")
            } else {
                // If the server returned an error (e.g., 404, 500), return an error message.
                Resource.Error("Server returned an error: ${response.code()}")
            }
        } catch (e: Exception) {
            // If an exception occurred (e.g., no internet), return an error message.
            e.printStackTrace()
            Resource.Error("Couldn't reach the server. Check your internet connection.")
        }
    }
}