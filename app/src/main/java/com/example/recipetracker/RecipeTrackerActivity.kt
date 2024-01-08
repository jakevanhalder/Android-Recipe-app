package com.example.recipetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.recipetracker.ui.theme.RecipeTrackerTheme

class RecipeTrackerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.josefinslab_thin, FontWeight.Thin),
            Font(R.font.josefinslab_extralight, FontWeight.Thin),
            Font(R.font.josefinslab_light, FontWeight.Thin),
            Font(R.font.josefinslab_regular, FontWeight.Thin),
            Font(R.font.josefinslab_medium, FontWeight.Thin),
            Font(R.font.josefinslab_semibold, FontWeight.Thin),
            Font(R.font.josefinslab_bold, FontWeight.Thin)
        )

        setContent{
            RecipeApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp(){
    RecipeTrackerTheme{
        Nav()

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val painter = painterResource(id = R.drawable.hamburger_steak_4)
            val description = "Burger steak recipe"
            val title = "Burger steak"
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            val items = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home
                ),
                BottomNavigationItem(
                    title = "Add recipe",
                    selectedIcon = Icons.Filled.AddCircle,
                    unselectedIcon = Icons.Outlined.AddCircle
                ),
                BottomNavigationItem(
                    title = "Profile",
                    selectedIcon = Icons.Filled.Person,
                    unselectedIcon = Icons.Outlined.Person
                )
            )

            /*
            * This scaffold is used to deal with the top app bar and the bottom navigational buttons
            * */
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "My Recipes",
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold
                            )
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
                        },
                        scrollBehavior = scrollBehavior
                    )
                },
                // Bottom navigation system
                bottomBar = {
                    androidx.compose.material3.NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    // navController.navigate(item.title) look this up
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex){
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { values ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(values)
                ){
                    items(100){
                        RecipeCard(
                            painter = painter,
                            contentDescription = description,
                            title = title,
                            fontFamily = fontFamily
                        )
                    }
                }

            }
        }
    }
}

