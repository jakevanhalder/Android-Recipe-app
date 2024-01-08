package com.example.recipetracker

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

/*
* Contract for information needed on every Recipe Tracker navigation destination
*/

interface RecipeTrackerDestination{
    val icon: ImageVector
    val route: String
}

/*
 * Recipe Tracker app navigation destinations
 */

object Home : RecipeTrackerDestination {
    override val icon = Icons.Filled.Home
    override val route = "home"
}

object AddRecipe : RecipeTrackerDestination {
    override val icon = Icons.Filled.AddCircle
    override val route = "addRecipe"
}

object Profile : RecipeTrackerDestination {
    override val icon = Icons.Filled.Person
    override val route = "profile"
}

// Screens to be displayed in the bottom navigation of the Recipe Tracker app
val recipeTrackerBottomNavigation = listOf(Home, AddRecipe, Profile)