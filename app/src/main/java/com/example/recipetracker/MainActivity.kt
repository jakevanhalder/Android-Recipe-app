package com.example.recipetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.RecipeTrackerTheme
import com.example.recipetracker.ui.theme.addRecipe.AddRecipeScreen
import com.example.recipetracker.ui.theme.home.HomeScreen
import com.example.recipetracker.ui.theme.profile.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent{
            RecipeTrackerTheme {
                RecipeApp()
            }
        }
    }
}

@Composable
fun RecipeApp()
{
    val navController = rememberNavController()
    RecipeTrackerNavHost(navController = navController)
}

@Preview
@Composable
fun RecipeAppPreview(){
    RecipeApp()
}