package com.alvaromenezes.bemacashreport.sales


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.alvaromenezes.bemacashreport.R
import com.alvaromenezes.bemacashreport.data.Sale
import com.alvaromenezes.bemacashreport.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_sales.*
import java.util.*


class SalesFragment : Fragment(), SalesContract.View {

    override fun getAdapter(): SalesAdapter {
        return adapter
    }


    lateinit var presenter: SalesPresenter
    private lateinit var adapter: SalesAdapter

    companion object {
        fun newInstance() = SalesFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = SalesPresenter(this)
        adapter = SalesAdapter(emptyList(), this)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_sales, container, false)

        val list = root.findViewById<RecyclerView>(R.id.sales_list)

        list.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context)
        }

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadSales(default = true)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        retainInstance = true
    }


    override fun showSaleDetail(sale: Sale) {

        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra(DetailActivity.SALE, sale)
        }
        startActivity(intent)


    }


    fun onSort() {

        val builder = AlertDialog.Builder(this!!.context!!)
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.dialog_sort, null)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group)


        var sortby = -1


        radioGroup.clearCheck()

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            sortby = i
        }


        builder.setView(view)
            .setPositiveButton(R.string.ok) { dialog, id ->

                presenter.sort(sortby )

            }
            .setNegativeButton(
                R.string.cancel
            ) { dialog, id -> }


        builder.create().show()

    }


    override fun showProgress(active: Boolean) {

        progressBar.apply {
            when (active) {
                true -> visibility = View.VISIBLE
                else -> visibility = View.GONE
            }
        }
    }

    override fun showSales(sales: List<Sale>) {

        adapter.updateSales(sales)
    }

    override fun showToas(msg: String) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        onSort()
        return true
    }




}
