package com.example.recipetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
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

@Composable
fun RecipeApp(){
    RecipeTrackerTheme{

    }
}