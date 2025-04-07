package com.example.todoapp.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.todoapp.navigation.DETAIL_PARAM
import com.example.todoapp.navigation.HOME_ROUTE
import com.example.todoapp.navigation.NUMBER_PARAM
import com.example.todoapp.navigation.Screens
import com.example.todoapp.screens.DetailedScreen
import com.example.todoapp.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screens.Home.route,
        route = HOME_ROUTE
    ){
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.Detail.route,
            arguments = listOf(
                navArgument(name = DETAIL_PARAM){
                    type = NavType.StringType
                    defaultValue = "String"
                },
                navArgument(name = NUMBER_PARAM){
                    type = NavType.IntType
                }
            )
        ) {
            val name = it.arguments?.getString(DETAIL_PARAM)
            val number = it.arguments?.getInt(NUMBER_PARAM).toString()
            DetailedScreen(navCntrl = navController, name = number ?: "", )
        }
    }
}
