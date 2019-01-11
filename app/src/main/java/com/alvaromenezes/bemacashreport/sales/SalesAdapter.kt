package com.alvaromenezes.bemacashreport.sales

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.bemacashreport.R
import com.alvaromenezes.bemacashreport.data.Sale
import kotlinx.android.synthetic.main.sale_item.view.*


class SalesAdapter(var sales: List<Sale>, private val salesView: SalesContract.View) :
    RecyclerView.Adapter<SalesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.sale_item, parent, false)
        return ViewHolder(v, salesView)
    }

    override fun getItemCount(): Int {
        return sales.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sales[position])
    }

    fun updateSales(sales: List<Sale>) {
        this.sales = sales
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View, private val salesView: SalesContract.View) : RecyclerView.ViewHolder(itemView) {

        fun bind(sale: Sale) {
            itemView.apply {
                with(sale) {

                    sale_item_status.text = orderStatus
                    sale_item_date.text = date
                    sale_item_price.text = totalPrice

                    val colorPrice = if (totalPrice.startsWith("-")) Color.RED else Color.BLUE
                    sale_item_price.setTextColor(colorPrice)

                }

                setOnClickListener { this@ViewHolder.salesView.showSaleDetail(sale) }
            }
        }
    }


}
