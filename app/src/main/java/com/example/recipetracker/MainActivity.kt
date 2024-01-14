package com.example.recipetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipetracker.ui.theme.RecipeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RecipeTrackerTheme {
                RecipeApp()
            }
        }
    }
}

@Composable
fun RecipeApp()
{

}

@Preview
@Composable
fun RecipeAppPreview(){
    RecipeApp()
}