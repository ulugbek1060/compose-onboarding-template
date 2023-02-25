package com.example.movieapp.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.movieapp.navigation.DetailScreen
import com.example.movieapp.navigation.HomeScreen
import com.example.movieapp.navigation.Screen

fun NavGraphBuilder.homeGraph(navController: NavHostController){
   navigation(
      route = HOME_GRAPH,
      startDestination = Screen.Home.route
   ){
      composable(
         route = Screen.Home.route,
         content = { HomeScreen(navController) }
      )
      composable(
         route = Screen.Detail.route,
         arguments = listOf(
            navArgument(
               name = "id",
               builder = {
                  type = NavType.IntType
                  defaultValue = -1
               }
            ),
            navArgument(
               name = "name",
               builder = {
                  type = NavType.StringType
                  defaultValue = ""
               }
            ),
         ),
         content = { DetailScreen(navController) }
      )
   }
}