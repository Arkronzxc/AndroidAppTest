package com.example.testapp.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id") val id: Long,
    @SerializedName("startAddress") val startAddress: Address,
    @SerializedName("endAddress") val endAddress: Address,
    @SerializedName("price") val price: Price,
    @SerializedName("orderTime") val orderTime: String,
    @SerializedName("vehicle") val vehicle: Vehicle
)