package com.example.movieapp.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.bottombar.screens.HomeScreen
import com.example.movieapp.bottombar.screens.ProfileScreen
import com.example.movieapp.bottombar.screens.SettingsScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
   NavHost(
      navController = navController,
      startDestination = BottomBarScreen.Home.route,
   ) {
      composable(
         route = BottomBarScreen.Home.route,
         content = { HomeScreen() }
      )
      composable(
         route = BottomBarScreen.Profile.route,
         content = { ProfileScreen() }
      )
      composable(
         route = BottomBarScreen.Setting.route,
         content = { SettingsScreen() }
      )
   }
}