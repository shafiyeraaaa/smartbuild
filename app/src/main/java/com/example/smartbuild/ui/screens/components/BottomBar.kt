package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        "Storage" to Icons.Default.Storage,
        "Camera" to Icons.Default.CameraAlt,
        "Home" to Icons.Default.Home,
        "Calendar" to Icons.Default.CalendarMonth,
        "Profile" to Icons.Default.Person
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFF0000CC)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { (label, icon) ->
            IconButton(onClick = { onItemSelected(label) }) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = if (label == selectedItem) Color.Yellow else Color.White
                )
            }
        }
    }
}
