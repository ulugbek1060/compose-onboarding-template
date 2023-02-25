package com.example.movieapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.movieapp.R


@Composable
fun TextField() {
   var text by remember { mutableStateOf("") }
   Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
   ) {
      androidx.compose.material.TextField(
         value = text, onValueChange = { newValue ->
            text = newValue
         },
         leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Email, contentDescription = "email")
            }
         },
         trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Check, contentDescription = "check")
            }
         },
         label = {
            Text(text = "Search...")
         },
         keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search,
         ),
         keyboardActions = KeyboardActions(onSearch = {
            println("Search");
         })
      )
   }
}

@Composable
fun CustomOutlinedTextField() {
   var text by remember { mutableStateOf("") }
   Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
   ) {
      OutlinedTextField(
         value = text, onValueChange = { newValue ->
            text = newValue
         },
         leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Email, contentDescription = "email")
            }
         },
         trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Check, contentDescription = "check")
            }
         },
         label = {
            Text(text = "Search...")
         },
         keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Search,
         ),
         keyboardActions = KeyboardActions(onSearch = {
            println("Search");
         })
      )
   }
}

@Composable
fun PasswordTextField() {
   Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      var password by remember { mutableStateOf("") }
      var passwordVisibility by remember { mutableStateOf(false) }
      val icon = if (passwordVisibility) painterResource(id = R.drawable.baseline_visibility_24)
      else painterResource(id = R.drawable.baseline_visibility_off_24)
      OutlinedTextField(
         value = password,
         onValueChange = { newValue ->
            password = newValue
         },
         label = {
            Text(text = "Password")
         },
         trailingIcon = {
            IconButton(onClick = {
               passwordVisibility = !passwordVisibility
            }) {
               Icon(painter = icon, contentDescription = "visibility")
            }
         },
         keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
         ),
         visualTransformation = if (passwordVisibility) VisualTransformation.None
         else PasswordVisualTransformation()
      )
   }
}