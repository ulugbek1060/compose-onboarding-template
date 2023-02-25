package com.example.onboardingdemo.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.onboardingdemo.navigation.Screen
import com.example.onboardingdemo.utils.OnBoardingPage
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
   navController: NavHostController,
   welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
   val pages = listOf(
      OnBoardingPage.First,
      OnBoardingPage.Second,
      OnBoardingPage.Third,
   )
   val pagerState = rememberPagerState()
   Column(modifier = Modifier.fillMaxSize()) {
      HorizontalPager(
         modifier = Modifier.weight(10f),
         count = 3,
         state = pagerState,
         verticalAlignment = Alignment.Top
      ) { position ->
         PagesScreen(onBoardingPage = pages[position])
      }
      HorizontalPagerIndicator(
         modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterHorizontally),
         pagerState = pagerState
      )
      FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
         welcomeViewModel.saveOnBoardingState(true)
         navController.popBackStack()
         navController.navigate(Screen.Home.route)
      }
   }
}


@Composable
fun PagesScreen(onBoardingPage: OnBoardingPage) {
   Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Image(
         modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.8f),
         painter = painterResource(id = onBoardingPage.image),
         contentDescription = onBoardingPage.title,
      )
      Text(
         modifier = Modifier.fillMaxWidth(),
         text = onBoardingPage.title,
         fontSize = MaterialTheme.typography.h4.fontSize,
         fontWeight = FontWeight.Bold,
         textAlign = TextAlign.Center
      )
      Text(
         modifier = Modifier.fillMaxWidth(),
         text = onBoardingPage.description,
         fontSize = MaterialTheme.typography.h6.fontSize,
         fontWeight = FontWeight.Normal,
         textAlign = TextAlign.Center
      )
   }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
   modifier: Modifier, pagerState: PagerState, onClick: () -> Unit
) {
   Row(
      modifier = modifier.padding(horizontal = 40.dp),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.Center
   ) {
      AnimatedVisibility(
         modifier = modifier.fillMaxWidth(),
         visible = pagerState.currentPage == 2
      ) {
         Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
               contentColor = Color.White
            )
         ) {
            Text(text = "Finish")
         }
      }
   }
}