package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.PersonSearch
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuGrid(
    onMenuClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(
        "Penjadwalan" to Icons.Default.DateRange,
        "Inspeksi" to Icons.Default.PersonSearch,
        "Biaya" to Icons.Default.AttachMoney,
        "Laporan" to Icons.Default.Description,
        "Cuaca" to Icons.Default.WbSunny,
        "Pelacakan" to Icons.Default.LocationOn,
        "Produktivitas" to Icons.Default.ShowChart,
        "Keselamatan" to Icons.Default.Warning
    )

    val columns = 4

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        menuItems.chunked(columns).forEachIndexed { index, rowItems ->
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = if (index == 0) 4.dp else 2.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { (label, icon) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp)
                            .clickable { onMenuClick(label) }
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = label,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(label, fontSize = 12.sp)
                    }
                }
                if (rowItems.size < columns) {
                    repeat(columns - rowItems.size) {
                        Spacer(modifier = Modifier.weight(0.5f))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(0.dp))
    }
}
