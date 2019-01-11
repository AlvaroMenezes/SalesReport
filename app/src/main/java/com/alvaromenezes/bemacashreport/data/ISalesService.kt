package com.alvaromenezes.bemacashreport.data

interface ISalesService {

    interface SalesServiceCallback {

        fun onSuccess(sales: List<Sale>)
        fun onFail(message: String)
    }

    fun getSales(initialDate: String, finalDate: String, callback: SalesServiceCallback)

}