package com.quansoft.quancast.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quansoft.quancast.features.login.ui.LoginScreen

@Composable
fun Navigation() {
    // Create a NavController to manage navigation state
    val navController = rememberNavController()

    // NavHost is the container for all your screens
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        // Define the composable for the Login screen
        composable(route = Screen.LoginScreen.route) {
            LoginScreen() // We will modify this later to pass the navController
        }

        // Define the composable for the Devices screen
        composable(route = Screen.DevicesScreen.route) {
            // This is a placeholder for now
            // TODO: Create the actual DevicesScreen
        }
    }
}
