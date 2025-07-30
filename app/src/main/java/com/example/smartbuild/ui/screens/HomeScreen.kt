package com.example.smartbuild.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartbuild.model.DailyReport
import com.example.smartbuild.ui.screens.components.*

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = {
            BottomBar(
                selectedItem = "Home",
                onItemSelected = { label ->
                    when (label) {
                        "Home" -> navController.navigate("home") {
                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                        "Calendar" -> navController.navigate("calendar_screen") {
                            popUpTo("home") {
                                inclusive = false
                            }
                        }
                        "Camera" -> navController.navigate("camera_screen") {
                            popUpTo("home") {
                                inclusive = false
                            }
                        }
                        "Storage" -> navController.navigate("storage_screen") {
                            popUpTo("home") {
                                inclusive = false
                            }
                        }
                        "Profile" -> navController.navigate("profile_screen") {
                            popUpTo("home") {
                                inclusive = false
                            }
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        val commonModifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TopBar(
                onNotificationClick = {
                    navController.navigate("notifications")
                }
            )
            SearchBar(navController = navController, modifier = commonModifier)
            WeatherCard(modifier = commonModifier)
            ProjectStatusCard(modifier = commonModifier)
            MenuGrid(
                onMenuClick = { menuName ->
                    when (menuName) {
                        "Penjadwalan" -> navController.navigate("schedule")
                        "Inspeksi" -> navController.navigate("inspection_screen")
                        "Biaya" -> navController.navigate("cost_screen")
                        "Laporan" -> navController.navigate("report_screen")
                        "Cuaca" -> navController.navigate("weather_screen")
                        "Pelacakan" -> navController.navigate("tracking_screen")
                        "Produktivitas" -> navController.navigate("productivity_screen")
                        "Keselamatan" -> navController.navigate("safety_screen")
                        else -> println("Menu tidak dikenal: $menuName")
                    }
                },
                modifier = commonModifier
            )
            val reports = listOf(
                DailyReport(
                    id = 1,
                    date = "17 Juli 2025",
                    project = "Gedung Tower A",
                    progress = "80% selesai",
                    activity = "Pemasangan plafon lantai 5"
                ),
                DailyReport(
                    id = 2,
                    date = "16 Juli 2025",
                    project = "Gedung Tower B",
                    progress = "75% selesai",
                    activity = "Pengecatan dinding lantai 3"
                ),
                DailyReport(
                    id = 3,
                    date = "15 Juli 2025",
                    project = "Gedung Tower C",
                    progress = "70% selesai",
                    activity = "Pemasangan instalasi listrik"
                )
            )
            Text(
                text = "Riwayat Laporan Harian",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                modifier = commonModifier.padding(top = 16.dp, bottom = 8.dp)
            )
            reports.forEach { report ->
                DailyReportCard(report = report, modifier = commonModifier)
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}