package com.example.onboardingdemo.navigation

sealed class Screen(val route: String) {
   object Welcome : Screen(route = "welcome-screen")
   object Home : Screen(route = "home-screen")
}
