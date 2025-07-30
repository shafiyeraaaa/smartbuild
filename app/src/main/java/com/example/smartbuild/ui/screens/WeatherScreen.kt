package com.example.smartbuild.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    onBackClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = "Cuaca",
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text("Proyek A", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Text("Yogyakarta", color = Color.Gray)
                Text("HUJAN", color = Color.Blue, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Menyesuaikan jadwal proyek\nMencegah kerja luar ruangan saat hujan")
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
                Text("Perkiraan Cuaca Ke Depan", fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))

                val days = listOf("Kamis", "Jumat", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu")
                val emojis = listOf("⛅", "🌧️", "🌧️", "⛅", "🌤️", "☀️", "🌤️")
                val temps = listOf("25° 23°", "20° 19°", "19° 20°", "19° 25°", "25° 23°", "25° 23°", "25° 23°")

                days.forEachIndexed { index, day ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(day)
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(emojis[index])
                            Text(temps[index])
                        }
                    }
                }
            }
        }
    }
}