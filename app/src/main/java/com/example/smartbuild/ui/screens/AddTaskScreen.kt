package com.example.smartbuild.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.smartbuild.model.ScheduleItem
import com.example.smartbuild.viewmodel.ScheduleViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    navController: NavController,
    viewModel: ScheduleViewModel = viewModel()
) {
    var taskName by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }
    var worker by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                deadline = "$dayOfMonth/${month + 1}/$year"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tugas Baru") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TaskField("Nama Tugas", "🛠", taskName) { taskName = it }
            TaskField("Waktu", "🕒", time) { time = it }
            OutlinedTextField(
                value = deadline,
                onValueChange = {},
                label = { Text("Deadline") },
                leadingIcon = { Text("📅", fontSize = 18.sp) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { datePickerDialog.show() },
                enabled = false,
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    disabledBorderColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
            )
            TaskField("Pekerja", "👷", worker) { worker = it }
            Button(
                onClick = {
                    val newTask = ScheduleItem(
                        day = getDayNameFromDate(deadline),
                        date = formatDateToLong(deadline),
                        taskName = taskName,
                    )
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("new_task", newTask)
                    navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4FC3F7))
            ) {
                Text("Tambah Tugas", color = Color.Black)
            }
        }
    }
}

@Composable
fun TaskField(
    label: String,
    emoji: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Text(text = emoji, fontSize = 18.sp) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        singleLine = true
    )
}

fun getDayNameFromDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("d/M/yyyy", Locale.getDefault())
    val outputFormat = SimpleDateFormat("EEEE", Locale("id", "ID"))
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date ?: Date()).replaceFirstChar { it.uppercase() }
}

fun formatDateToLong(dateString: String): String {
    val inputFormat = SimpleDateFormat("d/M/yyyy", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("id", "ID"))
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date ?: Date())
}



