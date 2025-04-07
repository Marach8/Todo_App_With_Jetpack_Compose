package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.navigation.nav_graph.SetUpNavGraph
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
//    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)
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


