package com.example.todoapp.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.navigation.Screens

@Composable
fun SignInScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "This is the login screen",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            modifier = Modifier
                .clickable {navController.navigate(Screens.Detail.passIdAndNo("Emmanuel", 100))}
                .padding(top = 100.dp),
            text = "Go to detail screen",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}



@Composable
@Preview(showBackground = true)
fun SignInPreview(){
    SignInScreen(navController = rememberNavController())
}