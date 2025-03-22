package com.example.todoapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CustomUI(
    canvas: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 500,
    bgIndicatorColor: Color = Color.LightGray,
    bgIndicatorStrokeWidth: Float = 50f,
    fgIndicatorColor: Color = Color.Blue,
    fgIndicatorStrokeWidth: Float = 50f,
    bigTextFontSize: TextUnit = 20.sp,
    bigTextColor: Color = MaterialTheme.colorScheme.surface,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining",
    smallTextFontSize: TextUnit = 10.sp,
    smallTextColor: Color = Color.Red
) {

    var allowedIndicatorValue by remember{mutableIntStateOf(maxIndicatorValue) }
    allowedIndicatorValue = if(indicatorValue <= maxIndicatorValue){
        indicatorValue
    } else{
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember{ mutableFloatStateOf(0f) }
    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat();
    }

    val percentage = (animatedIndicatorValue/maxIndicatorValue) * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(1000),
        label = ""
    )

    val receivedNumber by animateIntAsState(
        targetValue = allowedIndicatorValue,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    val animatedBigTextColor by animateColorAsState(
        targetValue = if(allowedIndicatorValue == 0)
            MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
            else bigTextColor,
        animationSpec = tween(durationMillis = 1000)
    )

    Column(
        modifier = Modifier
            .size(canvas)
            .drawBehind {
                val componentSize = size/ 1.25F
                bgIndicator(
                    indicatorColor = bgIndicatorColor,
                    indicatorStrokeWidth = bgIndicatorStrokeWidth,
                    componentSize = componentSize
                )
                fgIndicator(
                    sweepAngle = sweepAngle,
                    indicatorColor = fgIndicatorColor,
                    indicatorStrokeWidth = fgIndicatorStrokeWidth,
                    componentSize = componentSize
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CustomText(
            smallTextFontSize = smallTextFontSize,
            bigText = receivedNumber,
            smallText = smallText,
            bigTextColor = animatedBigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallTextColor = smallTextColor,
            bigTextFontSize = bigTextFontSize
        )
    }
}


fun DrawScope.bgIndicator(
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


fun DrawScope.fgIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
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
fun CustomText(
    bigText: Int,
    bigTextFontSize: TextUnit,
    bigTextColor: Color,
    bigTextSuffix: String,
    smallText: String,
    smallTextColor: Color,
    smallTextFontSize: TextUnit,
){
    Text(
        text = smallText,
        color = smallTextColor,
        fontSize = smallTextFontSize,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText ${bigTextSuffix.take(2)}",
        color = bigTextColor,
        fontSize = bigTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
@Preview(showBackground = true)
fun UIPreview(){
    CustomUI()
}


