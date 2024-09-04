package com.example.photographyapp.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.photographyapp.ui.screen.explore.ExploreScreen
import com.example.photographyapp.ui.screen.welcome.WelcomeScreen

@Composable
fun MyAppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "explore") {
        composable("welcome") { WelcomeScreen { navController.navigate("explore") } }
        composable("explore") { ExploreScreen(viewModel = hiltViewModel()){navController.navigate("profile")} }
        // composable("profile") { ProfileScreen(navController) }
    }
}