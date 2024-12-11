package com.app.tweetsy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.tweetsy.viewmodels.CategoriesViewModels

@Composable
fun CategoryScreen(navController: NavController,onClick:(category:String)->Unit) {
//    val categoriesViewModels: CategoriesViewModels = viewModel()
    val categoriesViewModels: CategoriesViewModels = hiltViewModel()
    val categories: State<List<String>> = categoriesViewModels.categories.collectAsState()
    if(categories.value.isEmpty()){
        Text(text = "Loading....")
    }else{
        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(4.dp)) {
            items(categories.value) {
                CategoryItem(it,navController, onClick)
            }
        }
    }
}

@Composable
fun CategoryItem(category: String,navController: NavController,onClick:(category:String)->Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onClick(category)
                //navController.navigate("DetailsScreen")
            }
            .aspectRatio(2f)
            .background(Color.Gray, shape = MaterialTheme.shapes.medium)
            .border(1.dp, Color.Black, MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            maxLines = 1, // Prevent overflow
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp) // Text padding
        )
    }
}