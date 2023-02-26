package com.example.movieapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

const val AUTHENTICATION_GRAPH = "authentication_graph"
const val ROOT_GRAPH = "root_graph"
const val HOME_GRAPH = "home_graph"

@Composable
fun SetUpNavGraph(navController: NavHostController) {
   NavHost(
      route = ROOT_GRAPH,
      navController = navController,
      startDestination = AUTHENTICATION_GRAPH,
   ) {
      homeGraph(navController = navController)
      authGraph(navController = navController)
   }
}