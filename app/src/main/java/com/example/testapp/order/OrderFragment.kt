package com.example.testapp.order

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.testapp.R
import com.example.testapp.model.Order
import com.example.testapp.utils.PicassoUtils
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    private lateinit var order: Order

    companion object {
        @JvmStatic
        fun newInstance(order: Order): Fragment {
            val orderFragment = OrderFragment()
            orderFragment.order = order
            return orderFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_order, container, false)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PicassoUtils.getCustomPicasso(context!!)!!
            .load("https://www.roxiemobile.ru/careers/test/images/" + order.vehicle.photo)
            .into(frg_order__photo)

        frg_order__date.text = order.orderTime
        frg_order__driver_name.text = order.vehicle.driverName
        frg_order__car_model.text = order.vehicle.modelName
        frg_order__reg_number.text = order.vehicle.regNumber
        frg_order__from.text = order.startAddress.address
        frg_order__to.text = order.endAddress.address
        frg_order__city.text = order.startAddress.city
        frg_order__price.text = order.price.amount.toString()
    }
}
