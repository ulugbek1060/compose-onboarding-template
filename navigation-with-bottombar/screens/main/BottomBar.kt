package com.example.movieapp.navigationgraph.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.movieapp.navigationgraph.graphs.MainScreens

sealed class BottomBarScreen(
   val route: String,
   val title: String,
   val icon: ImageVector,
) {

   object Home : BottomBarScreen(
      route = MainScreens.Home.route,
      title = "Home",
      icon = Icons.Default.Home
   )

   object Profile : BottomBarScreen(
      route = MainScreens.Profile.route,
      title = "Profile",
      icon = Icons.Default.Person
   )

   object Setting : BottomBarScreen(
      route = MainScreens.Settings.route,
      title = "Setting",
      icon = Icons.Default.Settings
   )
}
