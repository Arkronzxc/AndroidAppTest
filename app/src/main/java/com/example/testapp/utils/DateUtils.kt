package com.example.testapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtils {
    @RequiresApi(Build.VERSION_CODES.O)
    fun timeParser(input: String): String {
        val ldt = LocalDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        return "" + ldt.hour + ":" + ldt.minute
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateParser(input: String): String {
        val ldt: LocalDateTime = LocalDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        return "" + ldt.year + " " + ldt.month + " " + ldt.dayOfMonth
    }
}