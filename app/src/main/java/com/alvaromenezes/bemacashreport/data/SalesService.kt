package com.alvaromenezes.events.service

import com.alvaromenezes.bemacashreport.data.ISalesService
import com.alvaromenezes.bemacashreport.data.SalesAPI
import com.alvaromenezes.bemacashreport.data.SalesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalesService : ISalesService {



    override fun getSales(initialDate: String, finalDate: String, callback: ISalesService.SalesServiceCallback) {

        val params = HashMap<String, String>()
        params["initialDate"] = initialDate
        params["finalDate"] = finalDate


        val service = SalesAPI.create()

        val call = service.getSales(params)

        call.enqueue(object : Callback<SalesResponse> {

            override fun onResponse(call: Call<SalesResponse>?, response: Response<SalesResponse>) {
                if (response != null) {
                    if (response.isSuccessful) {

                        callback.onSuccess(response.body()!!.data)
                    }
                }
            }

            override fun onFailure(call: Call<SalesResponse>?, t: Throwable?) {
                if (t != null) {
                    callback.onFail(t.message!!)
                }
            }
        })

    }


}