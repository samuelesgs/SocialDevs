package com.saltwortdevs.socialdevs.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saltwortdevs.socialdevs.view.auth.login.LoginScreen
import com.saltwortdevs.socialdevs.view.auth.register.RegisterScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home  : Screen("home")
    object Register  : Screen("register")

}

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            //RegisterScreen()
            LoginScreen(navigateToRegister = { navController.navigate(Screen.Register.route) })
        }
        composable(Screen.Register.route) {
            RegisterScreen(navigateBack = {navController.popBackStack()})
        }
    }
}