package com.alvaromenezes.bemacashreport.sales

import com.alvaromenezes.bemacashreport.R
import com.alvaromenezes.bemacashreport.data.ISalesService
import com.alvaromenezes.bemacashreport.data.Sale
import com.alvaromenezes.bemacashreport.sales.SalesContract.Presenter
import com.alvaromenezes.bemacashreport.util.formatBR
import com.alvaromenezes.events.service.SalesService
import java.util.*

class SalesPresenter(val view: SalesContract.View) : Presenter {

    override fun loadSales(initialDate: String, finalDate: String, sortBy: Int, default: Boolean) {

        var init = initialDate
        var final = finalDate

        if (default) {

            final = Date().formatBR()
            with(Calendar.getInstance()) {
                add(Calendar.DAY_OF_YEAR, -500)
                init = time.formatBR()
            }
        }

        view.showProgress(true)

        var service = SalesService()
        service.getSales(
            init,
            final,
            object : ISalesService.SalesServiceCallback {
                override fun onSuccess(sales: List<Sale>) {

                    view.showSales(sales)
                    view.showProgress(false)
                }

                override fun onFail(message: String) {
                    view.showToas(message)
                    view.showProgress(false)

                }
            }
        )
    }


    fun sort( sortby: Int){


      val sales =   when (sortby) {

            R.id.radio_date_asc ->  sortByDateAsc(view.getAdapter().sales)
            R.id.radio_date_desc ->  sortByDateDesc(view.getAdapter().sales)
            R.id.radio_total_asc ->  sortByPriceASC(view.getAdapter().sales)
            R.id.radio_total_desc ->  sortByPriceDESC(view.getAdapter().sales)
           else -> view.getAdapter().sales

        }

        view.getAdapter().updateSales(sales)

    }


    override fun openSaleDetail(sale: Sale) {

        view.showSaleDetail(sale)
    }


    fun sortByDateAsc(sales: List<Sale>): List<Sale> {

        return sales.sortedBy { it.getDateTime }
    }

    fun sortByDateDesc(sales: List<Sale>): List<Sale> {

        return sales.sortedByDescending { it.getDateTime }
    }

    fun sortByPriceASC(sales: List<Sale>): List<Sale> {

        return sales.sortedBy { it.getTotalPrice }
    }

    fun sortByPriceDESC(sales: List<Sale>): List<Sale> {

        return sales.sortedByDescending { it.getTotalPrice }
    }


}