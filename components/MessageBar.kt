package com.example.movieapp.components

import androidx.compose.runtime.Composable

@Composable
fun MessageScreen() {
   val state = rememberMessageBarState()
   ContentWithMessageBar(messageBarState = state) {
      Column(
         modifier = Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Button(onClick = {
            state.addError(message = "Error occurred.")
         }) {
            Text(text = "Error")
         }
         Button(onClick = {
            state.addSuccess(message = "Successfully Updated.")
         }) {
            Text(text = "Success")
         }
      }
   }
}