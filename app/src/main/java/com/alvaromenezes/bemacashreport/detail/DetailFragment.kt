package com.alvaromenezes.bemacashreport.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvaromenezes.bemacashreport.R
import com.alvaromenezes.bemacashreport.data.Sale
import kotlinx.android.synthetic.main.fragment_detail.*


private const val SALE = "com.alvaromenezes.bemacashreport.detail.SALE"


class DetailFragment : Fragment(), DetailContract.View {


    lateinit var presenter: DetailPresenter

    companion object {

        @JvmStatic
        fun newInstance(sale: Sale) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(SALE, sale)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

            val sale = it.getSerializable(SALE) as Sale

            presenter = DetailPresenter(sale, this)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onResume() {
        super.onResume()
        presenter.showSale()
    }


    override fun showGratuity(gratuity: String) {
        detail_gratuity.text = gratuity
    }

    override fun showDiscount(discount: String) {
        detail_discount.text = discount
    }

    override fun showFreight(freight: String) {
        detail_freight.text = freight
    }

    override fun showTotalPrice(totalPrice: String) {
        detail_totalPrice.text = totalPrice
    }

    override fun showGrossPrice(grossPrice: String) {
        detail_grossPrice.text = grossPrice
    }

    override fun showSaleDate(saleDate: String) {
        detail_date.text = saleDate
    }

    override fun showSaleHour(saleHour: String) {

        detail_hour.text = saleHour
    }

    override fun showSaleType(saleType: String) {

        detail_sale_type.text = saleType
    }

    override fun showOrderStatus(orderStatu: String) {
        detail_status.text = orderStatu
    }

    override fun showPaymentGateway(paymentGateway: String) {
        detail_paymentGateway.text = paymentGateway
    }

    override fun showReceiptNumber(receiptNumber: String) {

        detail_receiptNumber.text = receiptNumber
    }

}
