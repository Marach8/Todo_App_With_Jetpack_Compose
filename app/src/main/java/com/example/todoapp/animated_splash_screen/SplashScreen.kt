package com.example.todoapp.animated_splash_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todoapp.ui.theme.Purple80
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    var startAnim by remember{ mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnim) 1f else 0f,
        animationSpec = tween(durationMillis = 3000),
        label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(AnScreens.MainScreen.route)
    }


    Box(
        modifier = Modifier
            .background(
                color = if(isSystemInDarkTheme()) Color.Black else Purple80
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alphaAnim.value),
            imageVector = Icons.Default.Email,
            contentDescription = "ImageIcon",
            tint = Color.White
        )
    }
}