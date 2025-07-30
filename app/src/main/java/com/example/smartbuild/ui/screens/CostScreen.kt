package com.example.smartbuild.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CostScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Biaya",
                        fontWeight = FontWeight.Bold
                    )
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
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Proyek Pembangunan Gedung", fontWeight = FontWeight.Bold)
                    Text("Rp. 1.000 - Rp. 2.000")
                    LinearProgressIndicator(
                        progress = 0.5f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { /* TODO */ }, modifier = Modifier.weight(1f)) {
                            Text("+ Tambah Data Biaya")
                        }
                        Button(onClick = { /* TODO */ }, modifier = Modifier.weight(1f)) {
                            Text("+ Tambah Data Material")
                        }
                    }
                }
            }
            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Pelacakan Biaya Material", fontWeight = FontWeight.Bold)
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    ) {
                        Text("📊 Grafik Placeholder", modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
            MaterialItemCard(
                title = "Perubahan Harga Material",
                name = "Semen",
                info1 = "Rp. 120 ↑",
                info2 = "Rp. 100",
                status = "Stok tersedia"
            )
            MaterialItemCard(
                title = "Stok dan Penggunaan Material",
                name = "Semen",
                info1 = "Stok tersedia",
                info2 = "Sudah digunakan",
                status = ""
            )
        }
    }
}

@Composable
fun MaterialItemCard(title: String, name: String, info1: String, info2: String, status: String) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(name)
                    Text(info1)
                    Text(info2)
                    if (status.isNotEmpty()) Text(status)
                }
                Icon(Icons.Default.QrCode, contentDescription = "QR", modifier = Modifier.size(40.dp))
            }
        }
    }
}
