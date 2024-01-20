package com.example.recipetracker.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun AddRecipeTopAppBar(modifier: Modifier = Modifier){
    
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
        ) {

        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = {
                        selectedTabIndex = 0
                    },
                    text = {
                        Text(text = "Overview")
                    }
                )

                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = {
                        selectedTabIndex = 1
                    },
                    text = {
                        Text(text = "Ingredients")
                    }
                )

                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = {
                        selectedTabIndex = 2
                    },
                    text = {
                        Text(text = "Directions")
                    }
                )

                Tab(
                    selected = selectedTabIndex == 3,
                    onClick = {
                        selectedTabIndex = 3
                    },
                    text = {
                        Text(text = "Photos")
                    }
                )
            }
        }
    
    }





}
