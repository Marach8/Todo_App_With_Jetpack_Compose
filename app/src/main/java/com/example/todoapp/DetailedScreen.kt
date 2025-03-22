package com.example.todoapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Composable
fun DetailedScreen(navCntrl: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
                //navCntrl.popBackStack()
                navCntrl.navigate(ScreenNav.Home.route){
                    popUpTo(ScreenNav.Home.route){
                        inclusive = true
                    }
                }
            },
            text = "Detailed Screen",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.display1.fontSize,
            color = Color.Green
        )
    }
}


@Composable
@Preview(showBackground = true)
fun DetailedScreenPrev(){
    DetailedScreen(navCntrl = rememberNavController())
}