package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smartbuild.R

@Composable
fun TopBar(onNotificationClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF00096B))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notification",
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    println("Notif diklik")
                    onNotificationClick()
                },
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}
