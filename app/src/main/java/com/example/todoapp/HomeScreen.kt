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
fun HomeScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Home Screen",
            modifier = Modifier.clickable {
                navController.navigate(
                    route = ScreenNav.Detail.passIdAndNo("Emmanuel Nnanna", number = 100)
                )
            },
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.display1.fontSize,
            color = Color.Black
        )
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPrev(){
    HomeScreen(navController = rememberNavController())
}