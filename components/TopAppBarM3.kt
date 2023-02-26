package com.example.movieapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreens() {
   val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
   Scaffold(
      modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
      topBar = {
         TopAppBar(
            scrollBehavior = scrollBehavior,
            title = {
               Text(
                  "Simple TopAppBar",
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
               )
            },
            actions = {
               // RowScope here, so these icons will be placed horizontally
               IconButton(onClick = { /* doSomething() */ }) {
                  Icon(
                     imageVector = Icons.Filled.Favorite,
                     contentDescription = "Localized description"
                  )
               }
               IconButton(onClick = { /* doSomething() */ }) {
                  Icon(
                     imageVector = Icons.Filled.Favorite,
                     contentDescription = "Localized description"
                  )
               }
            },
         )
      },
      content = { innerPadding ->
         LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
         ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
               Text(
                  text = list[it],
                  style = MaterialTheme.typography.bodyLarge,
                  modifier = Modifier
                     .fillMaxWidth()
                     .padding(horizontal = 16.dp)
               )
            }
         }
      }
   )
}