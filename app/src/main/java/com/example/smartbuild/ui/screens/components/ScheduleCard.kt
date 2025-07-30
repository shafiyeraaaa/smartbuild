package com.example.smartbuild.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartbuild.model.ScheduleItem

@Composable
fun ScheduleCard(item: ScheduleItem) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Card(
        shape = RoundedCornerShape(12.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier
                    .background(primaryColor)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.day,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = item.date,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = item.taskName,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}