package com.example.movieapp.navigationgraph.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.navigationgraph.screens.main.MainScreen

object Graphs {
   const val ROOT = "root_graph"
   const val AUTHENTICATION = "auth_graph"
}

sealed class RootScreens(val route: String) {
   object Main : RootScreens(route = "main_screen")
}

@Composable
fun RootGraph(navController: NavHostController) {
   NavHost(
      navController = navController,
      startDestination = Graphs.AUTHENTICATION,
      route = Graphs.ROOT
   ) {
      authGraph(navController = navController)
      composable(
         route = RootScreens.Main.route,
         content = { MainScreen() }
      )
   }
}

