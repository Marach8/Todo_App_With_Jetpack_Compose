package com.example.todoapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.todoapp.navigation.Screens

@Composable
fun DetailedScreen(navCntrl: NavController, name: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = name,
                color = Color.Black
            )
            Text(
                modifier = Modifier.clickable {
                    navCntrl.popBackStack()
//                    navCntrl.navigate(Screens.Home.route){
//                        popUpTo(Screens.Home.route){
//                            inclusive = true
//                        }
//                    }
                },
                text = "$name in Detailed screen",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.display1.fontSize,
                color = Color.Green
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DetailedScreenPrev(){
    DetailedScreen(navCntrl = rememberNavController(), name = "")
}