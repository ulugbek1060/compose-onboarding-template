package com.example.movieapp.navigation

sealed class Screen(val route: String) {
   object Home : Screen(route = "home-screen")
   object Detail : Screen(route = "detail-screen?id={id}&name={name}") {
      //   object Detail : Screen(route = "detail-screen/{id}/{name}") {
//      fun passArg(id: Int, name: String): String {
//         return "detail-screen/$id/$name"
//      }
      fun passArg(id: Int? = 0, name: String? = ""): String {
         return "detail-screen?id=$id&name=$name"
      }

      fun navigate(): String {
         return "detail-screen"
      }
   }

   object Login : Screen(route = "login-screen")
   object SignUp : Screen(route = "sign-up-screen")
}
