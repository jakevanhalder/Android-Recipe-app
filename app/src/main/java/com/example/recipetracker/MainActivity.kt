package com.example.recipetracker

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipetracker.ui.theme.RecipeTrackerTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
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

        setContent {
            RecipeTrackerTheme {

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

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
                            NavigationBar {
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
    }
}

/*
* Name: RecipeCard()
* Description: Creates a image card for recipes that are added to the app
* Status: Not done. Haven't integrated the user creating these yet
* */
@Composable
fun RecipeCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(7.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                )
            ){

            }
            Text(text = title,
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) : Unit
{

}