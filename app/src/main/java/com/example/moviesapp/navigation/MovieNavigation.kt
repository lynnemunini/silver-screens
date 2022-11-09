package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.screens.details.DetailsScreen
import com.example.moviesapp.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    // NavController: Central API for navigation component
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            // Pass where this should lead user to
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name + "/{movie}", arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}