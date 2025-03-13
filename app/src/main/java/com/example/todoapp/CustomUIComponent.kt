package com.example.todoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha

@Composable
fun CustomUI(
    canvas: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    bgIndicatorColor: Color = MaterialTheme.colorScheme.onSurface.copy(
        alpha = 0.1f
    ),
    bgIndicatorStrokeWidth: Float = 100f
) {
    Column(
        modifier = Modifier
            .size(canvas)
            .drawBehind {
                val componentSize = size/ 1.25F
                backGroundIndicator(
                    indicatorColor = bgIndicatorColor,
                    indicatorStrokeWidth = bgIndicatorStrokeWidth,
                    componentSize = componentSize
                )
            }
    ){

    }
}


fun DrawScope.backGroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y = (size.height - componentSize.height)/2f
        )
    )
}



@Composable
@Preview(showBackground = true)
fun UIPreview(){
    CustomUI()
}


