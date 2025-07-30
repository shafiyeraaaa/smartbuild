package com.example.smartbuild.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController

data class NotificationItem(
    val icon: String,
    val title: String,
    val subtitle: String? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    val notifications = listOf(
        NotificationItem("⚠️", "Pekerja tanpa helm terdeteksi", "Zona 3 – 14:05"),
        NotificationItem("🌪️", "Cuaca ekstrem mendekat", "Zona 1 – Angin kencang"),
        NotificationItem("✅", "Laporan harian 16 Juli diterima", "Zona 2 oleh Rizal H. – 17:03"),
        NotificationItem("⚠️", "Pekerja tanpa APD terdeteksi di Zona 4", "14:23 | Sistem AI mendeteksi 1 pekerja tanpa rompi"),
        NotificationItem("🔥", "Risiko pengelasan tidak terpantau", "AI menyarankan evaluasi lokasi kerja Zona 1"),
        NotificationItem("🧯", "APAR (Alat Pemadam) belum diperiksa 7 hari", "Mohon lakukan pengecekan mingguan"),
        NotificationItem("🔔", "Anda belum mengirim laporan harian hari ini", "Batas waktu: 17:00"),
        NotificationItem("✅", "Supervisor menyetujui laporan 15 Juli", "Progres proyek dicatat 92%"),
        NotificationItem("📎", "4 lampiran baru ditambahkan", "ke laporan Zona 2"),
        NotificationItem("👷", "Aktivitas 'Pengecoran Lantai 2' dimulai", "pukul 08:00\nCek persiapan & personel"),
        NotificationItem("📅", "Rapat Proyek Mingguan dimulai 30 menit lagi", "Lokasi: Kantor Lapangan B")
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Notifikasi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(notifications) { notif ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    border = CardDefaults.outlinedCardBorder(),
                    colors = CardDefaults.outlinedCardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = notif.icon,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                        Column {
                            Text(
                                text = notif.title,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                            notif.subtitle?.let {
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = it,
                                    fontSize = 13.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}