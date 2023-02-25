package com.example.movieapp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun SignUpScreen(navController: NavHostController) {
   Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
   ) {
      Text(
         modifier = Modifier.clickable {
            navController.popBackStack()
         },
         text = "Sign up",
         color = MaterialTheme.colors.secondary,
         fontSize = MaterialTheme.typography.h3.fontSize,
         fontWeight = FontWeight.Bold,
      )
   }
}