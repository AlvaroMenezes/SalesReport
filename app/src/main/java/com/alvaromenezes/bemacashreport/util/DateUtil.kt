package com.alvaromenezes.bemacashreport.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


fun Date.formatBR(): String = android.text.format.DateFormat.format("dd/MM/yyyy", this).toString()

class DateUtil {


    fun validateDateSmallOrEqual(dateSmaller: String, dateGrater: String): Boolean {

        val smaller = LocalDate.parse(dateSmaller, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val greater = LocalDate.parse(dateGrater, DateTimeFormatter.ofPattern("dd/MM/yyyy"))

        return smaller <= greater
    }
}