package com.example.recipetracker.ui.theme.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recipetracker.R
import com.example.recipetracker.ui.theme.components.BottomBar
import com.example.recipetracker.ui.theme.components.RecipeCard
import com.example.recipetracker.ui.theme.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(value = "My Recipes")
        },
        bottomBar = {
            NavigationBar {
                BottomBar()
            }
        }
    ) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
        ){
            items(100) {
                RecipeCard(
                    painter = painterResource(id = R.drawable.hamburger_steak_4),
                    contentDescription = "Burger Steak Recipe",
                    title = "Burger Steak",
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Default
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}