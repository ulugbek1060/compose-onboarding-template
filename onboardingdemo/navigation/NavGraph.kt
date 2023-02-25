package com.example.onboardingdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboardingdemo.screens.HomeScreen
import com.example.onboardingdemo.screens.WelcomeScreen

@Composable
fun SetupNavGraph(
   navController: NavHostController,
   startDestination: String
) {
   NavHost(
      navController = navController,
      startDestination = startDestination,
   ) {
      composable(
         route = Screen.Welcome.route,
         content = {
            WelcomeScreen(navController = navController)
         }
      )
      composable(
         route = Screen.Home.route,
         content = {
            HomeScreen()
         }
      )
   }
}