package com.example.smartbuild.model

data class DailyReport(
    val id: Int,
    val date: String,
    val project: String,
    val progress: String,
    val activity: String
)