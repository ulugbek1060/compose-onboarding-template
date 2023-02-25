package com.example.movieapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R

@Composable
fun CircularImage() {
   Image(
      modifier = Modifier
         .size(200.dp)
         .clip(RoundedCornerShape(size = 20.dp))
         .border(
            width = 30.dp,
            color = Color.Cyan,
            shape = RoundedCornerShape(size = 20.dp)
         ),
      painter = painterResource(id = R.drawable.ic_launcher_background),
      contentDescription = "img"
   )
}