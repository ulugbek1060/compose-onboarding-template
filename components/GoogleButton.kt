package com.example.movieapp.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
   text: String = "Sign up with Google",
   loadingText: String = "Creating Account...",
   icon: Painter = painterResource(id = R.drawable.google_icon),
   shapes: Shape = Shapes.medium,
   backgroundColor: Color = MaterialTheme.colors.surface,
   borderColor: Color = Color.LightGray,
   progressIndicatorColor: Color = MaterialTheme.colors.primary,
   onClicked: () -> Unit
) {
   var clicked by remember { mutableStateOf(false) }
   Surface(
      onClick = { clicked = !clicked },
      shape = shapes,
      border = BorderStroke(width = 1.dp, color = borderColor),
      color = backgroundColor
   ) {
      Row(
         modifier = Modifier
            .padding(
               top = 12.dp,
               bottom = 12.dp,
               start = 12.dp,
               end = 16.dp,
            )
            .animateContentSize(
               animationSpec = tween(
                  durationMillis = 300,
                  easing = LinearOutSlowInEasing
               )
            ),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
      ) {
         Icon(
            painter = icon,
            contentDescription = "google_icon",
            tint = Color.Unspecified
         )
         Spacer(modifier = Modifier.width(8.dp))
         Text(text = if (clicked) loadingText else text)
         Spacer(modifier = Modifier.width(8.dp))
         if (clicked) {
            Spacer(modifier = Modifier.width(6.dp))
            CircularProgressIndicator(
               color = progressIndicatorColor,
               strokeWidth = 2.dp,
               modifier = Modifier
                  .height(16.dp)
                  .width(16.dp)
            )
            onClicked()
         }
      }
   }
}