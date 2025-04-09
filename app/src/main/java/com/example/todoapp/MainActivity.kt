package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.animated_shimmer.AnimatedShimmer
import com.example.todoapp.bottom_navigation_bar.screens.MainScreen
import com.example.todoapp.navigation.nav_graph.SetUpNavGraph
import com.example.todoapp.topappbar.AppBarScreen
import com.example.todoapp.topappbar.MainViewModel
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    //late init var navController: NavHostController
    //val navController = rememberNavController()
    //private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                Column(){
                    repeat(10){
                        AnimatedShimmer()
                    }
                }
                //AppBarScreen(viewModel = viewModel)
//                MainScreen()
//                SetUpNavGraph(navController = navController)
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ){
//                    var value by remember { mutableIntStateOf(0) }
//                    CustomUI(
//                        indicatorValue = value,
//                    )
//                    TextField(
//                        value = value.toString(),
//                        onValueChange = {
//                            value = if(it.isNotEmpty()){
//                                it.toInt()
//                            }
//                            else{
//                                0
//                            }
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Number
//                        )
//                    )
//                }
            }
        }
    }
}


