package com.example.smartbuild.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScheduleItem(
    val day: String,
    val date: String,
    val taskName: String
) : Parcelable

