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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SafetyScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Keselamatan", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                color = Color(0xFFFFCDD2),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("🔴 Risiko Tinggi", fontWeight = FontWeight.Bold)
                    Text("📍 Lokasi : Proyek A Blok 3")
                    Text("⏰ Waktu : 14 Juni 2025, 09.45")
                    Button(
                        onClick = { /* TODO: Show Detail */ },
                        modifier = Modifier.align(Alignment.End).padding(top = 8.dp)
                    ) {
                        Text("Detail")
                    }
                }
            }
            Text("📊 Risiko Pekerjaan", fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(listOf(Color.Blue, Color.Magenta)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Grafik Placeholder", color = Color.White)
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("⚠ Risiko akan meningkat dalam 15 menit", fontWeight = FontWeight.SemiBold)
                Text("🌧 Cuaca ekstrem terdeteksi mendekat")

                Divider()

                CheckboxItem("Konfirmasi semua APD terdistribusi")
                CheckboxItem("Hentikan aktivitas saat angin kencang")
                CheckboxItem("Panggil pekerja keluar dari zona risiko")
                CheckboxItem("Kirim laporan ke manajer lapangan")
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Red, shape = RoundedCornerShape(30.dp))
                ) {
                }
            }
        }
    }
}

@Composable
fun CheckboxItem(label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Checkbox(checked = false, onCheckedChange = {})
        Text(label)
    }
}