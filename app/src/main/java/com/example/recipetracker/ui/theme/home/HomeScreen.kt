package com.example.recipetracker.ui.theme.home

import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.recipetracker.R
import com.example.recipetracker.ui.theme.components.RecipeCard
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen(
    onClickHomeButton: () -> Unit = {},
    onClickAddRecipeButton: () -> Unit = {},
    onClickProfileButton: (String) -> Unit = {},
) {
    val painter = painterResource(id = R.drawable.hamburger_steak_4)
    val description = "Burger Steak Recipe"
    val title = "Burger Steak"

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .semantics { contentDescription = "Home Screen" }
    ) {
        items(100){
        RecipeCard(painter = painter, contentDescription = description, title = title, fontFamily = androidx.compose.ui.text.font.FontFamily.Default)
            }
    }
}