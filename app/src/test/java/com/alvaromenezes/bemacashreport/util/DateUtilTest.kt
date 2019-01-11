package com.alvaromenezes.bemacashreport.util

import android.text.format.DateUtils
import com.alvaromenezes.bemacashreport.data.Sale
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class DateUtilTest {

    @Test
    fun validateStringdateAreEqualORSmaller() {

        Assert.assertTrue(DateUtil().validateDateSmallOrEqual("23/10/2015", "23/10/2018"))
        Assert.assertTrue(DateUtil().validateDateSmallOrEqual("23/10/2015", "23/10/2015"))
        Assert.assertFalse(DateUtil().validateDateSmallOrEqual("23/10/2016", "23/10/2015"))
    }

}
