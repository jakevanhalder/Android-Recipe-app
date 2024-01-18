package com.example.recipetracker.ui.theme.addRecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.components.AddRecipeTopAppBar
import com.example.recipetracker.ui.theme.components.UserTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecipeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            AddRecipeTopAppBar(value = "New Recipe")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            UserTextField("Recipe Name")

            UserTextField("Preparation Time")

            UserTextField("Cooking Time")
        }
    }
}

@Preview
@Composable
fun AddRecipeScreenPreview(){
    AddRecipeScreen(rememberNavController())
}