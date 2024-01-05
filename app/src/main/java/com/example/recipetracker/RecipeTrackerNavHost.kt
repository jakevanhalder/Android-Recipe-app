package com.example.recipetracker

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.addRecipe.AddRecipeScreen
import com.example.recipetracker.ui.theme.home.HomeScreen
import com.example.recipetracker.ui.theme.login.LoginScreen
import com.example.recipetracker.ui.theme.profile.ProfileScreen

@Composable
fun Nav()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "LoginScreen"){

        composable(route = "LoginScreen"){
            LoginScreen(navController)
        }
        composable(route = "HomeScreen"){
            HomeScreen(navController)
        }
        composable(route = "RecipeScreen"){
            AddRecipeScreen(navController)
        }
        composable(route = "ProfileScreen"){
            ProfileScreen(navController)
        }
    }
}