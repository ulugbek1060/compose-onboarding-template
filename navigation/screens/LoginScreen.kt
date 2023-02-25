package com.example.movieapp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.movieapp.navigation.nav_graph.AUTHENTICATION_GRAPH
import com.example.movieapp.navigation.nav_graph.HOME_GRAPH

@Composable
fun LoginScreen(navController: NavHostController) {
   Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceAround
   ) {
      Text(
         modifier = Modifier.clickable {
            navController.navigate(HOME_GRAPH) {
               popUpTo(AUTHENTICATION_GRAPH) {
                  inclusive = false
               }
            }
         },
         text = "Login",
         color = Color.Red,
         fontSize = MaterialTheme.typography.h3.fontSize,
         fontWeight = FontWeight.Bold,
      )
      Text(
         modifier = Modifier.clickable {
            navController.navigate(Screen.SignUp.route)
         },
         text = "Sign up",
      )
      Text(
         modifier = Modifier.clickable {
            navController.navigate(Screen.Detail.route)
         },
         text = "to Detail",
      )
   }
}