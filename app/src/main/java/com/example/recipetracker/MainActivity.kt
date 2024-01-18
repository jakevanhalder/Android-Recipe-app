package com.example.recipetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.RecipeTrackerTheme
import com.example.recipetracker.ui.theme.components.RecipeTrackerBottomNavigation
import com.example.recipetracker.ui.theme.components.RecipeTrackerTopAppBar

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp()
{
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            RecipeTrackerTopAppBar(value = "My Recipes")
        },
        bottomBar = {
            RecipeTrackerBottomNavigation()
        }
    ) { padding ->
        RecipeTrackerNavHost(navController, Modifier.padding(padding))
    }
}

@Preview
@Composable
fun RecipeAppPreview(){
    RecipeApp()
}