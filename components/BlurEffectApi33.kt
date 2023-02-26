package com.example.movieapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp

@Composable
fun BlurScreen() {
   Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
   ) {
      Text(
         text = "Hello Blur Effect", modifier = Modifier.blur(
            radius = 10.dp,
            edgeTreatment = BlurredEdgeTreatment.Unbounded
         )
      )
   }
}