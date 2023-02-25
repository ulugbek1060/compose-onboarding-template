package com.example.movieapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.movieapp.navigation.nav_graph.AUTHENTICATION_GRAPH

fun NavGraphBuilder.authGraph(navController: NavHostController) {
   navigation(
      startDestination = Screen.Login.route,
      route = AUTHENTICATION_GRAPH
   ) {
      composable(
         route = Screen.Login.route,
         content = { LoginScreen(navController) }
      )
      composable(
         route = Screen.SignUp.route,
         content = { SignUpScreen(navController) }
      )
   }
}