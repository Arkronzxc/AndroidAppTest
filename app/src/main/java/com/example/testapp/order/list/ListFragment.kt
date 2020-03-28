package com.example.testapp.order.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.R
import com.example.testapp.model.Order
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private var adapter: OrderAdapter? = null

    private lateinit var onOrderClickListener: (Order) -> Unit

    companion object {
        @JvmStatic
        fun newInstance(onOrderClickListener: (Order) -> Unit): Fragment {
            val orderFragment = ListFragment()
            orderFragment.onOrderClickListener = onOrderClickListener
            return orderFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this)[OrderViewModel::class.java]

        viewModel.getOrdersData().observe(this, Observer { orders ->
            Log.d("TAG", "observe")
            adapter?.updateOrders(orders)
        })

        adapter = OrderAdapter(onOrderClickListener)
        frg_list__recycler.adapter = adapter
    }
}
