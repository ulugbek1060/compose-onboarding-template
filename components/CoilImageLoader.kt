package com.example.movieapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.movieapp.R

@Composable
fun CoilImage() {
   Box(
      modifier = Modifier.size(200.dp),
      contentAlignment = Alignment.Center
   ) {
      val painter = rememberAsyncImagePainter(
         model = ImageRequest.Builder(LocalContext.current)
            .data("https://i.pinimg.com/originals/5c/bd/6f/5cbd6f67abf25a872e98375c74711a7b.jpg")
            .placeholder(R.drawable.google_icon)
            .error(R.drawable.ic_launcher_background)
            .transformations(
//               CircleCropTransformation()
               RoundedCornersTransformation(50f),
            )
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
      )

      if (painter.state is AsyncImagePainter.State.Loading) {
         CircularProgressIndicator()
      }

      Image(
         painter = painter,
         contentDescription = "image"
      )
//      if (painter.state is AsyncImagePainter.State.Success) {
//         // This will be executed during the first composition if the image is in the memory cache.
//      }
   }

}