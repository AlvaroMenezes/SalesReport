package com.alvaromenezes.bemacashreport.sales

import com.alvaromenezes.bemacashreport.data.ISalesService
import com.alvaromenezes.bemacashreport.data.Sale
import com.alvaromenezes.events.service.SalesService
import junit.framework.Assert
import org.hamcrest.CoreMatchers.any
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SalesPresenterTest {


    val sales = listOf(Sale(saleDate = "25/11/2018 18:58:53",  totalPrice = "2,00"),
                        Sale(saleDate = "25/11/2018 18:58:53",  totalPrice = "3,00"),
                        Sale(saleDate = "22/11/2018 18:58:53",  totalPrice = "1,00"),
                        Sale(saleDate = "22/11/2018 19:58:53",  totalPrice = "1,00"),
                        Sale(saleDate = "29/11/2018 18:58:53",  totalPrice = "2,00"))


    lateinit var salesPresenter: SalesPresenter

    @Captor
    lateinit var  captor: ArgumentCaptor<ISalesService.SalesServiceCallback>

    @Mock
    lateinit var view: SalesContract.View



    @Before
    fun setupSalesPresenterTest(){

        MockitoAnnotations.initMocks(this)

        salesPresenter = SalesPresenter(view)

    }


    @Test
    fun clickOnItem_ShowsDetailsUi() {

        val sale = Sale()
        salesPresenter.openSaleDetail(sale)

        verify(view).showSaleDetail(sale)
    }




    @Test
    fun sort_ListOfSalesByPriceAsc(){

        val sale = salesPresenter.let {
            it.sortByPriceASC(sales) }[0]

        Assert.assertEquals(sale.totalPrice, "1,00")
    }

    @Test
    fun sort_ListOfSalesByPriceDesc(){

        val sale = salesPresenter.let {
            it.sortByPriceDESC(sales)}[0]
        Assert.assertEquals(sale.totalPrice, "3,00")
    }

    @Test
    fun sort_ListOfSalesByDateAsc(){

        val sale = salesPresenter.let {
            it.sortByDateAsc(sales) }[0]

        Assert.assertEquals(sale.saleDate, "22/11/2018 18:58:53")
    }

    @Test
    fun sort_ListOfSalesByDateDesc(){

        val sales = salesPresenter.let {
            it.sortByDateDesc(sales) }

        Assert.assertEquals(sales[0].saleDate, "29/11/2018 18:58:53")
    }


}