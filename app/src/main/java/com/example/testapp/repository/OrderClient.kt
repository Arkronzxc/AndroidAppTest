package com.example.testapp.repository

import com.example.testapp.model.Order
import retrofit2.Call
import retrofit2.http.GET

interface OrderClient {
    @GET("/careers/test/orders.json")
    fun getOrders(): Call<List<Order>>
}