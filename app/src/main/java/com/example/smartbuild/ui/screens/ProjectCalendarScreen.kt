package com.example.smartbuild.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartbuild.R
import com.example.smartbuild.ui.screens.components.BottomBar

@Composable
fun ProjectCalendarScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        bottomBar = {
            BottomBar(
                selectedItem = "Calendar",
                onItemSelected = { label ->
                    when (label) {
                        "Home" -> navController.navigate("home")
                        "Calendar" -> navController.navigate("calendar_screen")
                        "Camera" -> println("Camera clicked")
                        "Menu" -> println("Menu clicked")
                        "Profile" -> println("Profile clicked")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Kalender Proyek",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Juni 2025",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
            CalendarDummy()
            Spacer(modifier = Modifier.height(16.dp))
            for (i in 1..15) {
                DailyReportCard(
                    title = "Laporan Harian $i",
                    date = "${17 - (i - 1)} Juli 2025"
                )
            }
            Spacer(modifier = Modifier.height(80.dp)) // agar tidak ketutup bottom bar
        }
    }
}

@Composable
fun DailyReportCard(title: String, date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_laporanday1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEFECEF))
                    .padding(12.dp)
            ) {
                Text(text = "■ $title", fontWeight = FontWeight.Medium)
                Text(text = date, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun CalendarDummy() {
    val days = listOf("Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab")

    val dates = mutableListOf<String>()
    val startOffset = 0
    val totalDays = 30

    repeat(startOffset) {
        dates.add("")
    }
    for (i in 1..totalDays) {
        dates.add(i.toString())
    }
    while (dates.size % 7 != 0) {
        dates.add("")
    }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            days.forEach {
                Text(text = it, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        val rows = dates.chunked(7)
        rows.forEach { week ->
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                week.forEach { day ->
                    Box(
                        modifier = Modifier
                            .size(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = day)
                    }
                }
            }
        }
    }
}