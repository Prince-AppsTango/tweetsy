package com.app.tweetsy

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.app.tweetsy.api.TweetsyApi
import com.app.tweetsy.navigation.AppNavigation
import com.app.tweetsy.screens.CategoryScreen
import com.app.tweetsy.screens.DetailsScreen
import com.app.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           AppNavigation()
        }
    }
}


//    @Inject
//    lateinit var tweetsyApi: TweetsyApi

//        Test code
//        GlobalScope.launch {
//         var response = tweetsyApi.getCategories()
//            Log.d("Prince", "onCreate: ${response.body()!!.distinct()}")
//        }