package com.example.todoapp.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoapp.navigation.AUTH_ROUTE
import com.example.todoapp.navigation.HOME_ROUTE
import com.example.todoapp.navigation.ROOT_ROUTE

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ){
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}