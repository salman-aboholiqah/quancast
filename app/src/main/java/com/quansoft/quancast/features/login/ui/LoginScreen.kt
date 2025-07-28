package com.quansoft.quancast.features.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quansoft.quancast.core.util.Resource

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    // State for the API Key input field
    var apiKey by remember { mutableStateOf("") }

    // Collect the state from the ViewModel
    val devicesState by viewModel.devicesState.collectAsState()

    // Determine if the button should be enabled based on the state
    val isButtonEnabled = when (val state = devicesState) {
        is Resource.Loading -> !state.isLoading
        else -> true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter API Key", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = apiKey,
            onValueChange = { apiKey = it },
            label = { Text("API Key") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { viewModel.onGetDevicesClicked(apiKey) },
            modifier = Modifier.fillMaxWidth(),
            // Use the simplified boolean state for the button
            enabled = isButtonEnabled
        ) {
            Text("Get Devices")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Handle the different states from the ViewModel
        when (val state = devicesState) {
            is Resource.Loading -> {
                if (state.isLoading) {
                    CircularProgressIndicator()
                }
            }
            is Resource.Error -> {
                Text(
                    text = state.message ?: "An unknown error occurred.",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            is Resource.Success -> {
                // On success, you would typically navigate to the next screen.
                // For now, we'll just show a success message.
                val deviceCount = state.data?.devices?.size ?: 0
                Text(
                    text = "Success! Found $deviceCount device(s).",
                    color = MaterialTheme.colorScheme.primary, // Use theme color for success
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
