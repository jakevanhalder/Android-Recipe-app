package com.example.recipetracker.ui.theme.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.recipetracker.AddRecipe
import com.example.recipetracker.Home
import com.example.recipetracker.Profile

@Composable
fun RecipeTrackerBottomNavigation(navController: NavHostController,modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Home.icon,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            },
            selected = true,
            onClick = {
                navController.navigate(Home.route)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = AddRecipe.icon,
                    contentDescription = "Add Recipe"
                )
            },
            label = {
                Text("Add Recipe")
            },
            selected = false,
            onClick = {
                navController.navigate(AddRecipe.route)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Profile.icon,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            },
            selected = false,
            onClick = {
                navController.navigate(Profile.route)
            }
        )
    }
}
