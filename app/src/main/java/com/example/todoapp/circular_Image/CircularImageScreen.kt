package com.example.todoapp.circular_Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun CircularImageScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .border(
                    width = 10.dp,
                    color = Color.Cyan,
                    shape = CircleShape
                ),
            painter = painterResource(id = R.drawable.avatar_image),
            contentDescription = "Avatar Image"
        )
    }

}


@Composable
@Preview
fun CircularImagePreview(){
    CircularImageScreen()
}