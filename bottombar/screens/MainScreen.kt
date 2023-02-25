package com.example.movieapp.bottombar.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieapp.bottombar.BottomBarScreen
import com.example.movieapp.bottombar.BottomNavGraph


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
   Scaffold(
      bottomBar = {
         BottomBar(navController = navController)
      },
      content = {
         BottomNavGraph(navController = navController)
      }
   )
}

@Composable
fun BottomBar(
   navController: NavHostController
) {
   val screens = listOf(
      BottomBarScreen.Home,
      BottomBarScreen.Profile,
      BottomBarScreen.Setting,
   )

   val navBackStackEntry = navController.currentBackStackEntryAsState()
   val currentDestination = navBackStackEntry.value?.destination

   BottomNavigation {
      screens.forEach { screen ->
         AddItem(
            screen = screen,
            currentDestination = currentDestination,
            navController = navController,
         )
      }
   }
}

@Composable
fun RowScope.AddItem(
   screen: BottomBarScreen,
   currentDestination: NavDestination?,
   navController: NavHostController,
) {
   BottomNavigationItem(
      label = { Text(text = screen.title) },
      icon = {
         Icon(
            imageVector = screen.icon,
            contentDescription = screen.title
         )
      },
      unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
      selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
      onClick = {
         navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id) // this to move to start destination of bottomNavGraph
            launchSingleTop = true // this to avoid multiple copy of destinations
         }
      }
   )
}

