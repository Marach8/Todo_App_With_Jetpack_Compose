package com.example.todoapp.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.todoapp.navigation.AUTH_ROUTE
import com.example.todoapp.navigation.Screens

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "This is the Home Screen",
            modifier = Modifier.clickable {

//                navController.navigate(
//                    route = Screens.Detail.passIdAndNo("Emmanuel Nnanna", number = 100)
//                )
            },
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.display1.fontSize,
            color = Color.Black
        )
        Text(
            text = "Login/SignUp",
            color = Color.Red,
            modifier = Modifier
                .padding(top = 100.dp)
                .clickable {
                    navController.navigate(AUTH_ROUTE)
                },
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPrev(){
    HomeScreen(navController = rememberNavController())
}