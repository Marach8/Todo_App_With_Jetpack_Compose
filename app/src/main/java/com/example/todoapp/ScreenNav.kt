package com.example.todoapp

sealed class ScreenNav(val route: String) {
    object Home: ScreenNav(route = "home_nav")
    object Detail: ScreenNav(route = "detail_nav")
}