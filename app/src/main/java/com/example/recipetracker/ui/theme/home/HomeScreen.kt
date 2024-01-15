package com.example.recipetracker.ui.theme.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.ui.theme.components.TopBar

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("My Recipes")

            /*items(100) {
                RecipeCard(
                    painter = painterResource(id = R.drawable.hamburger_steak_4),
                    contentDescription = "Burger Steak Recipe",
                    title = "Burger Steak",
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default
                )
            }*/
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}