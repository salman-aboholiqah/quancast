package com.quansoft.quancast.features.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quansoft.quancast.features.login.data.remote.ApiKeyRequest
import com.quansoft.quancast.features.login.data.remote.DevicesResponse
import com.quansoft.quancast.features.login.data.repository.AuthRepository
import com.quansoft.quancast.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    // StateFlow to hold the UI state (Loading, Success, or Error)
    private val _devicesState = MutableStateFlow<Resource<DevicesResponse>>(Resource.Loading(false))
    val devicesState = _devicesState.asStateFlow()
    fun onGetDevicesClicked(apiKey: String)
    {
        if (apiKey.isBlank()) {
            _devicesState.value = Resource.Error("API Key cannot be empty.")
            return
        }

        // Launch a coroutine to call the repository
        viewModelScope.launch {
            // Set the state to Loading
            _devicesState.value = Resource.Loading(true)

            // Make the API call
            val result = repository.getDevices(ApiKeyRequest(apiKey))

            // Update the state with the result
            _devicesState.value = result
        }
    }
}