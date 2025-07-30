package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartbuild.R
import com.example.smartbuild.model.DailyReport

@Composable
fun DailyReportCard(report: DailyReport, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_laporanday1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_laporanday1),
                        contentDescription = "Laporan",
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = "Laporan Harian ${report.id}",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = report.date,
                    fontSize = 11.sp,
                    color = androidx.compose.ui.graphics.Color.Gray
                )
            }
        }
    }
}