package com.example.movieapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

data class CustomData(
   val id: Int,
   val image: String,
   val title: String,
   val description: String,
   val badges: List<ImageVector>
)

@Composable
fun AdaptiveLayout() {

   val items = mutableListOf<CustomData>()

   for (number in 0 until 10) {
      items.add(
         element = CustomData(
            id = number,
            image = "https://picsum.photos/id/$number/300/300",
            title = "#$number Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
            badges = listOf(
               Icons.Default.Check,
               Icons.Default.Edit,
               Icons.Default.Face,
               Icons.Default.Email,
               Icons.Default.List,
               Icons.Default.Home
            )
         )
      )
   }

   LazyColumn(
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
   ) {
      items(items = items, key = { it.id }) {
         CustomCard(data = it)
      }
   }
}

@Composable
fun CustomCard(data: CustomData) {
   Row(modifier = Modifier.border(width = 1.dp, color = Color.LightGray)) {
      AsyncImage(
         modifier = Modifier
            .weight(1f),
         model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(true)
            .build(),
         contentDescription = "Card Image",
         contentScale = ContentScale.Crop
      )

      Spacer(modifier = Modifier.width(12.dp))

      BoxWithConstraints(
         modifier = Modifier
            .weight(1.5f)
            .padding(vertical = 12.dp)
      ) {
         AdaptiveContent(data = data)
      }
   }
}

@Composable
fun BoxWithConstraintsScope.AdaptiveContent(data: CustomData) {
   val badgeSize = 24.dp
   val padding = 24.dp
   val numberOfBadgesToShow = maxWidth.div(badgeSize + padding).toInt().minus(1)
   val remainingBadges = data.badges.size - numberOfBadgesToShow

   Log.d("HomeScreen", "${this.maxWidth}")
   Column(verticalArrangement = Arrangement.SpaceBetween) {
      Text(
         text = data.title,
         style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h5.fontSize
         ),
         maxLines = 1,
         overflow = TextOverflow.Ellipsis
      )
      Spacer(modifier = Modifier.height(12.dp))
      Text(
         text = data.description,
         color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
         maxLines = if (this@AdaptiveContent.maxWidth > 250.dp) 10 else 2,
         overflow = TextOverflow.Ellipsis
      )
      Spacer(modifier = Modifier.height(12.dp))
      Row(horizontalArrangement = Arrangement.spacedBy(space = padding)) {
         data.badges.take(numberOfBadgesToShow).forEach {
            Icon(
               modifier = Modifier.size(badgeSize),
               tint = MaterialTheme.colors.primary,
               imageVector = it,
               contentDescription = "Badge Icon"
            )
         }
         if (remainingBadges > 0) {
            Box(
               modifier = Modifier
                  .clip(CircleShape)
                  .background(Color.LightGray)
                  .padding(6.dp)
            ) {
               Text(
                  text = "+$remainingBadges",
                  style = TextStyle(fontSize = MaterialTheme.typography.caption.fontSize)
               )
            }
         }
      }
   }
}