package com.alvaromenezes.bemacashreport.data

import java.io.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class Sale(
    val gratuity: String = "",
    val discount: String = "",
    val freight: String = "",
    val totalPrice: String = "",
    val grossPrice: String = "",
    val saleId: String = "",
    val saleDate: String = "",
    val saleType: String = "",
    val orderStatus: String = "",
    val paymentGateway: String = "",
    val receiptNumber: String = ""
) : Serializable {

    val date: String
        get() {
            return saleDate.split(" ")[0]
        }
    val hour: String
        get() {
            return saleDate.split(" ")[1]
        }

    val getDateTime: LocalDate
        get() {
            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH)
            val date = LocalDate.parse(saleDate, dtf)
            return date
        }

    val getTotalPrice: Double
        get() {
            return totalPrice.replace(",",".").trim().toDouble()
        }

}