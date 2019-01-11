package com.alvaromenezes.bemacashreport.sales

import com.alvaromenezes.bemacashreport.data.Sale

interface SalesContract {

    interface View {

        fun showProgress(active: Boolean)

        fun showSales(sales: List<Sale>)

        fun showSaleDetail(sale: Sale)

        fun showToas(msg: String)

        fun getAdapter() :SalesAdapter
    }

    interface Presenter {

        fun loadSales(initialDate: String = "", finalDate: String = "", sortBy: Int = -1, default: Boolean = false)

        fun openSaleDetail(sale: Sale)


    }

}