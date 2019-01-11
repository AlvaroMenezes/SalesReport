package com.alvaromenezes.bemacashreport.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface SalesAPI {

    @GET("sales")
    @Headers(
        "Content-Type: application/json",
        "Authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJOQU1FIjoiUmFmYWVsIiwiTE9HSU4iOiJwZXp6ZXR0aSIsIlNIT1BfSUQiOiIxNTA2MiIsIlVQREFURV9USU1FIjoiMjAxOS0wMS0wNCAxMDoxMDowMiJ9.9V-fH9AK1LwUzkJ_OkbgM4upILqlJYc16Uphlg5opJE"
    )
    fun getSales(@QueryMap params: Map<String, String>): Call<SalesResponse>


    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): SalesAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://merchant.bemacash.com.br/apiv3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(SalesAPI::class.java);
        }
    }


}