package com.example.movieapp.navigationgraph.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun SignUpScreen(
   navigate: () -> Unit
) {
   Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
   ) {
      Text(
         modifier = Modifier.clickable {
            navigate()
         },
         text = "Sign up",
      )
   }
}