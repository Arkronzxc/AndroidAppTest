package com.example.testapp.repository

import android.util.Log
import com.example.testapp.model.Order
import com.example.testapp.utils.RequestUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val TAG = OrderService::class.java.simpleName

class OrderService {
    private var orderClient: OrderClient? = null

    init {
        orderClient = RequestUtils.client?.create(OrderClient::class.java)
    }

    companion object {
        @JvmStatic
        private var instance: OrderService? = null

        @JvmStatic
        fun getInstance(): OrderService = if (instance == null) OrderService() else instance!!
    }

    fun getOrders(callback: (List<Order>) -> Unit) {
        Log.d("TAG", "OrderService_getOrders")

        val call = orderClient?.getOrders()

        call?.enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                if (response.isSuccessful) {
                    callback(response.body()!!)
                }
                Log.d("TAG", "msg = " + response.message() + "code = " + response.code())
                Log.d("TAG", "url = " + response.raw().request().url().toString())
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                Log.d(TAG, "Fail" + t.localizedMessage)
            }
        })
    }
}