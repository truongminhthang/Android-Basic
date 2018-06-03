package com.example.quakereport

import java.text.SimpleDateFormat
import java.util.*

fun Long.toTimeString() : String {
    val timeFormat = SimpleDateFormat("hh:mm a")
    val dateObject = Date(this)
    return timeFormat.format(dateObject)
}

fun Long.toDateString(): String {
    val dateFormat = SimpleDateFormat("LLL dd, yyyy", Locale("vie") )
    val dateObject = Date(this)
    return dateFormat.format(dateObject)
}