package com.alvaromenezes.bemacashreport.sales

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.alvaromenezes.bemacashreport.R

class SalesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        initFragment(SalesFragment.newInstance())

    }

    private fun initFragment(salesFragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            add(R.id.contentFrame, salesFragment)
            commit()
        }
    }

}
