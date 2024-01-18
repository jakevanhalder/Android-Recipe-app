package com.example.recipetracker.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipetracker.AddRecipe
import com.example.recipetracker.Home
import com.example.recipetracker.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTrackerTopAppBar(modifier: Modifier = Modifier, value: String){

    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        TopAppBar(
            title = {
                Text(text = value)
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search for recipes"
                    )
                }
            }
        )
    }
}


@Composable
fun RecipeTrackerBottomNavigation(modifier: Modifier = Modifier) {
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
            onClick = {}
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
            onClick = {}
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
            onClick = {}
        )
    }
}
