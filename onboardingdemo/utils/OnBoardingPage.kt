package com.example.onboardingdemo.utils

import com.example.onboardingdemo.R

sealed class OnBoardingPage(
   val image: Int,
   val title: String,
   val description: String,
) {
   object First : OnBoardingPage(
      image = R.drawable.ic_launcher_foreground,
      title = "Meeting",
      description = "Lorem ipsum dolor amet",
   )

   object Second : OnBoardingPage(
      image = R.drawable.ic_launcher_foreground,
      title = "Coordination",
      description = "Lorem ipsum dolor amet",
   )

   object Third : OnBoardingPage(
      image = R.drawable.ic_launcher_foreground,
      title = "Dialog",
      description = "Lorem ipsum dolor amet",
   )
}
