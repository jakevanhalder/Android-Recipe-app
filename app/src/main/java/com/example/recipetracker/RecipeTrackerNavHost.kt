package com.example.recipetracker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.addRecipe.AddRecipeScreen
import com.example.recipetracker.ui.theme.home.HomeScreen
import com.example.recipetracker.ui.theme.login.LoginScreen
import com.example.recipetracker.ui.theme.profile.ProfileScreen

@Composable
fun RecipeTrackerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ){
        composable(route = Home.route) {
            HomeScreen()
        }

        composable(route = AddRecipe.route) {
            AddRecipeScreen()
        }

        composable(route = Profile.route) {
            ProfileScreen()
        }

        }
    }


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }