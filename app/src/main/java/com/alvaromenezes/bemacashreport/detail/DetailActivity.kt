package com.alvaromenezes.bemacashreport.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.alvaromenezes.bemacashreport.R
import com.alvaromenezes.bemacashreport.data.Sale

class DetailActivity : AppCompatActivity() {


    companion object {
        const val SALE = "com.alvaromenezes.bemacashreport.DetailActivity.SALE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras

        if (bundle != null) {
            with(bundle) {
                initFragment(DetailFragment.newInstance(get(SALE) as Sale))
            }
        }
    }

    private fun initFragment(salesFragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            add(R.id.contentDetailFrame, salesFragment)
            commit()
        }
    }


}
