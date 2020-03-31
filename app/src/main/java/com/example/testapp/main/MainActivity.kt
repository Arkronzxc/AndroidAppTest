package com.example.testapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R
import com.example.testapp.model.Order
import com.example.testapp.order.OrderFragment
import com.example.testapp.order.list.ListFragment
import com.example.testapp.utils.FragmentUtils

val TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FragmentUtils.changeFragment(
            ListFragment.newInstance {
                showOrder(it)
            },
            supportFragmentManager,
            R.id.main_container
        )
    }

    private fun showOrder(order: Order) {
        FragmentUtils.changeFragment(
            OrderFragment.newInstance((order)),
            supportFragmentManager,
            R.id.main_container,
            TAG
        )
    }
}
