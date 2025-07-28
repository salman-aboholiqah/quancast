package com.quansoft.quancast.navigation // Create a new 'navigation' package

/**
 * A sealed class to define the routes for navigation in a type-safe way.
 * @param route The string path for the screen.
 */
sealed class Screen(val route: String) {
    data object LoginScreen : Screen("login_screen")
    data object DevicesScreen : Screen("devices_screen")
}
