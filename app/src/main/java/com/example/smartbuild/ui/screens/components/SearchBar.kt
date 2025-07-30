package com.example.smartbuild.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartbuild.R

@Composable
fun SearchBar(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("location_search")
                }
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Cari lokasi proyek...") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.LightGray,
                    disabledLeadingIconColor = Color.Gray,
                    disabledLabelColor = Color.Gray,
                    disabledPlaceholderColor = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
