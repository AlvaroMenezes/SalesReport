package com.alvaromenezes.bemacashreport.detail

import com.alvaromenezes.bemacashreport.data.Sale

class DetailPresenter(val sale: Sale, val view: DetailContract.View) : DetailContract.Presenter {


    override fun showSale() {

        view.showGratuity(sale.gratuity)

        view.showDiscount(sale.discount)

        view.showFreight(sale.freight)

        view.showTotalPrice(sale.totalPrice)

        view.showGrossPrice(sale.grossPrice)

        view.showSaleDate(sale.date)

        view.showSaleHour(sale.hour)

        view.showSaleType(sale.saleType)

        view.showOrderStatus(sale.orderStatus)

        view.showPaymentGateway(sale.paymentGateway)

        view.showReceiptNumber(sale.receiptNumber)

    }


}