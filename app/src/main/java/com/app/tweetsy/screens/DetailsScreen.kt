package com.app.tweetsy.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.tweetsy.models.Tweet
import com.app.tweetsy.viewmodels.DetailViewModels
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailsScreen() {
//    val tweets: DetailViewModels = viewModel()
    val tweets: DetailViewModels = hiltViewModel()
    val tweet: State<List<Tweet>> = tweets.tweets.collectAsState()
   if(tweet.value.isEmpty()){
       Text(text = "Loading...")
   }else{
       LazyColumn {
           items(tweet.value){
               DetailsScreenItem(it)
           }
       }
   }
}

@Composable
fun DetailsScreenItem(tweet: Tweet) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .shadow(elevation = 8.dp, shape = MaterialTheme.shapes.medium)
            .background(color = Color.White, MaterialTheme.shapes.medium)

    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = tweet.category, color = Color.Black, fontSize = 20.sp)
            Text(text = tweet.text, color = Color.Black, fontSize = 18.sp)
        }
    }

}