package com.example.smartbuild.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackingScreen(
    onBackClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = "Pelacakan",
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            Text("Pasir", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            // Bar status
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .background(Color.Blue)
                )
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .height(4.dp)
                        .background(Color.LightGray)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("dikirim", fontSize = 12.sp)
                Text("dalam perjalanan", fontSize = 12.sp)
                Text("tiba", fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Lokasi
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📦 Supplier A")
                Spacer(modifier = Modifier.width(16.dp))
                Text("📍 Lokasi Proyek", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider()

            Spacer(modifier = Modifier.height(12.dp))

            TrackingItem("Besi", "Stok 150 Batang", "cukup", Color(0xFFB2FF59))
            TrackingItem("Semen", "Stok 20 Sak", "menipis", Color(0xFFFFFF00))
            TrackingItem("Batu Bata", "Stok 0 Buah", "habis", Color(0xFFFF8A80))
        }
    }
}

@Composable
fun TrackingItem(title: String, subtitle: String, status: String, statusColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(title, fontWeight = FontWeight.SemiBold)
            Text(subtitle, fontSize = 12.sp, color = Color.Gray)
        }
        Box(
            modifier = Modifier
                .background(statusColor, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(status, fontSize = 12.sp)
        }
    }
}