package com.alvaromenezes.bemacashreport.data

import org.junit.Assert
import org.junit.Test

class SaleTest {

    var saleFake = Sale( saleDate=  "29/11/2018 18:58:53")

    @Test
    fun date_isCorrect() {
        Assert.assertEquals("29/11/2018",saleFake.date )
    }

    @Test
    fun hour_isCorrect() {
        Assert.assertEquals("18:58:53",saleFake.hour)
    }

}