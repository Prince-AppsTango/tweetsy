package com.app.tweetsy.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.tweetsy.screens.CategoryScreen
import com.app.tweetsy.screens.DetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "CategoryScreen") {
        composable(route = "CategoryScreen") {
            CategoryScreen(navController){
                navController.navigate("DetailsScreen/${it}")
            }
        }
        composable(route = "DetailsScreen/{category}", arguments = listOf(
            navArgument("category"){
                type= NavType.StringType
            }
        )) {
                DetailsScreen()
        }
    }
}