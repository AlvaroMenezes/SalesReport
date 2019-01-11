package com.alvaromenezes.bemacashreport.detail


interface DetailContract {

    interface View {

        fun showGratuity(gratuity: String)

        fun showDiscount(discount: String)

        fun showFreight(freight: String)

        fun showTotalPrice(totalPrice: String)

        fun showGrossPrice(grossPrice: String)

        fun showSaleDate(saleDate: String)

        fun showSaleHour(saleHour: String)

        fun showSaleType(saleType: String)

        fun showOrderStatus(orderStatu: String)

        fun showPaymentGateway(paymentGateway: String)

        fun showReceiptNumber(receiptNumber: String)
    }

    interface Presenter {

        fun showSale()
    }
}