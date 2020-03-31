package com.example.testapp.order.list

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.Order
import com.example.testapp.utils.DateUtils
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter(val onOrderClickListener: (Order) -> Unit) :
    RecyclerView.Adapter<OrderAdapter.OrderHolder>() {

    private val orders: MutableList<Order> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return OrderHolder(view)
    }

    override fun getItemCount() = orders.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.bind(orders[position])
        holder.itemView.setOnClickListener {
            onOrderClickListener(orders[position])
        }
    }

    fun updateOrders(orders: List<Order>) {
        this.orders.clear()
        this.orders.addAll(orders)
        notifyDataSetChanged()
    }

    class OrderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateUtils = DateUtils()

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(order: Order) {
            itemView.item_order__from.text = order.startAddress.address
            itemView.item_order__to.text = order.endAddress.address
            itemView.item_order__date.text = dateUtils.dateParser(order.orderTime)
            itemView.item_order__price.text =  order.price.amount
            itemView.item_order__currency.text = order.price.currency.symbol
        }
    }
}
