package com.example.todoapp.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.todoapp.navigation.AUTH_ROUTE
import com.example.todoapp.navigation.Screens
import com.example.todoapp.screens.SignInScreen
import com.example.todoapp.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screens.SignIn.route,
        route = AUTH_ROUTE
    ){
        composable(
            route = Screens.SignIn.route
        ) {
            SignInScreen(navController = navController)
        }
        composable(
            route = Screens.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }
    }
}