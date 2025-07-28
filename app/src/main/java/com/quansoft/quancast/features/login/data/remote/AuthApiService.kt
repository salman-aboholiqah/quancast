package com.quansoft.quancast.features.login.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit interface for authentication-related API calls.
 */
interface AuthApiService {

    /**
     * Fetches the list of devices associated with a given API key.
     * @param request The request body containing the API key.
     * @return A Retrofit Response wrapping the DevicesResponse.
     */
    @POST("v1/get-devices")
    suspend fun getDevices(@Body request: ApiKeyRequest): Response<DevicesResponse>
}
