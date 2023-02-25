package com.example.movieapp.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeSystemUiColors() {
   //implementation "com.google.accompanist:accompanist-systemuicontroller:0.28.0"
   val systemUiController = rememberSystemUiController()
   // Remember a SystemUiController
   val useDarkIcons = !isSystemInDarkTheme()

   DisposableEffect(systemUiController, useDarkIcons) {
      // Update all of the system bar colors to be transparent, and use
      // dark icons if we're in light theme
      systemUiController.setSystemBarsColor(
         color = Color.Transparent,
         darkIcons = useDarkIcons
      )

      // setStatusBarColor() and setNavigationBarColor() also exist

      onDispose {}
   }
}