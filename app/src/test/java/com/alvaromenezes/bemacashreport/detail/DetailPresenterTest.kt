package com.alvaromenezes.bemacashreport.detail

import com.alvaromenezes.bemacashreport.data.Sale
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


 class DetailPresenterTest {

    @Mock
    lateinit var view: DetailContract.View

     lateinit var sale: Sale


     lateinit var presenter: DetailPresenter

    @Before
    fun setupNotesPresenter() {

        MockitoAnnotations.initMocks(this)

        sale =   Sale(  gratuity= "0,00",
            discount= "0,00",
            freight= "0,00",
            totalPrice= "-7,00",
            grossPrice= "-7,00",
            saleId= "60200b2d-90ba-4b63-980f-fd42140b706f",
            saleDate= "29/11/2018 18:58:53",
            saleType= "Normal",
            orderStatus= "ESTORNADA",
            paymentGateway= "Dinheiro",
            receiptNumber= "111-39")

        presenter = DetailPresenter(sale,view)

    }

     @Test
     fun showDetailOfSelectedSaleFrom(){

         presenter.showSale()

         verify(view).showSaleDate(sale.date)
         verify(view).showDiscount(sale.discount)
         verify(view).showFreight(sale.freight)
         verify(view).showGratuity(sale.gratuity)
         verify(view).showGrossPrice(sale.grossPrice)
         verify(view).showOrderStatus(sale.orderStatus)
         verify(view).showSaleHour(sale.hour)
         verify(view).showReceiptNumber(sale.receiptNumber)
         verify(view).showSaleType(sale.saleType)
         verify(view).showPaymentGateway(sale.paymentGateway)
         verify(view).showTotalPrice(sale.totalPrice)

     }

}