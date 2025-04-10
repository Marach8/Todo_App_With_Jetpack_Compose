package com.example.todoapp.animated_splash_screen

sealed class AnScreens(val route: String) {
    data object SplashScreen: AnScreens(route = "splash_screen")
    data object MainScreen: AnScreens(route = "main_screen")
}