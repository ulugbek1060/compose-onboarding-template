package com.example.onboardingdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.onboardingdemo.navigation.SetupNavGraph
import com.example.onboardingdemo.screens.SplashViewModel
import com.example.onboardingdemo.ui.theme.OnBoardingDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   lateinit var navController: NavHostController

   @Inject
   lateinit var splashViewModel: SplashViewModel

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      installSplashScreen().setKeepOnScreenCondition {
         !splashViewModel.isLoading.value
      }

      setContent {
         OnBoardingDemoTheme {
            val screen by splashViewModel.startDestination
            navController = rememberNavController()
            SetupNavGraph(
               navController = navController,
               startDestination = screen,
            )
         }
      }
   }
}
