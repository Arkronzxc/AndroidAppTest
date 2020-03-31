package com.example.testapp.order.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.model.Order
import com.example.testapp.repository.OrderService

class OrderViewModel : ViewModel() {

    private lateinit var ordersData: MutableLiveData<List<Order>>

    fun getOrdersData(): LiveData<List<Order>> {
        if (!this::ordersData.isInitialized) {
            ordersData = MutableLiveData()
            loadOrders()
        }

        return ordersData
    }

    private fun loadOrders() {
        Log.d("TAG", "loadOrders")

        OrderService.getInstance().getOrders { orders ->
            ordersData.postValue(orders)
        }
    }


}