package com.example.movieapp.navigationgraph.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.movieapp.navigationgraph.screens.ForgotScreen
import com.example.movieapp.navigationgraph.screens.auth.LoginScreen
import com.example.movieapp.navigationgraph.screens.SignUpScreen


sealed class AuthScreens(val route: String) {
   object Signup : AuthScreens("signup_screen")
   object Login : AuthScreens("login_screen")
   object Forgot : AuthScreens("forgot_screen")
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
   navigation(
      route = Graphs.AUTHENTICATION,
      startDestination = AuthScreens.Login.route,
   ) {
      composable(route = AuthScreens.Login.route, content = {
         LoginScreen(navigate = { navController.navigate(RootScreens.Main.route) })
      })
      composable(route = AuthScreens.Signup.route,
         content = { SignUpScreen(navigate = { navController.popBackStack() }) })
      composable(route = AuthScreens.Forgot.route,
         content = { ForgotScreen(navigate = { navController.popBackStack() }) })
   }
}