package com.example.movieapp.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimatedLazyColumn() {
   var cars by remember {
      mutableStateOf(
         listOf(
            "BMW M1",
            "BMW M2",
            "BMW M3",
            "BMW M4",
            "BMW M5"
         )
      )
   }

   LazyColumn(
      verticalArrangement = Arrangement.spacedBy(12.dp),
      content = {
         items(items = cars, key = { it }) {
            Text(
               modifier = Modifier
                  .fillMaxWidth()
                  .background(Color.LightGray.copy(alpha = 0.2f))
                  .padding(12.dp)
                  .animateItemPlacement(),
               text = it,
               fontSize = MaterialTheme.typography.h5.fontSize,
               fontWeight = FontWeight.Bold,
            )
         }
         item {
            Button(
               modifier = Modifier.fillMaxWidth(),
               onClick = { cars = cars.shuffled() }) {
               Text(text = "Shuffle")
            }
         }
      }
   )
}