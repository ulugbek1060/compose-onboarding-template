package com.example.movieapp.navigationgraph.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.navigationgraph.screens.main.*

sealed class MainScreens(val route: String) {
   object Home : MainScreens(route = "home_screen")
   object Profile : MainScreens(route = "profile_screen")
   object Settings : MainScreens(route = "settings_screen")
   object Detail : MainScreens(route = "detail_screen")
   object Overview : MainScreens(route = "overview_screen")
}

@Composable
fun MainGraph(navController: NavHostController) {
   NavHost(
      navController = navController,
      startDestination = MainScreens.Home.route
   ) {
      bottomNavScreens(navController = navController)
      detailScreens(navController = navController)
   }
}

fun NavGraphBuilder.bottomNavScreens(navController: NavHostController) {
   composable(
      route = MainScreens.Home.route,
      content = { HomeScreen(navigate = { navController.navigate(MainScreens.Detail.route) }) }
   )
   composable(
      route = MainScreens.Profile.route,
      content = { ProfileScreen(navigate = {}) }
   )
   composable(
      route = MainScreens.Settings.route,
      content = { SettingsScreen(navigate = {}) }
   )
}

fun NavGraphBuilder.detailScreens(navController: NavHostController) {
   composable(
      route = MainScreens.Detail.route,
      content = { DetailScreen(navigate = { navController.navigate(MainScreens.Overview.route) }) }
   )
   composable(
      route = MainScreens.Overview.route,
      content = { OverviewScreen(navigate = { navController.popBackStack() }) }
   )
}