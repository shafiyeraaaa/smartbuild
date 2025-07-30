package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.smartbuild.R

@Composable
fun WeatherCard(modifier: Modifier = Modifier) {
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_sun))
    val progress = animateLottieCompositionAsState(composition.value)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFB3E5FC),
                        Color(0xFFF0F0F0)
                    )
                )
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("📍 Yogyakarta", fontWeight = FontWeight.Bold)
            Text("32°", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
        LottieAnimation(
            composition = composition.value,
            progress = progress.value,
            modifier = Modifier.size(80.dp)
        )
    }
}