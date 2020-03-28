package com.example.testapp.model

import com.google.gson.annotations.SerializedName

data class Vehicle(
    @SerializedName("regNumber") val regNumber: String,
    @SerializedName("modelName") val modelName: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("driverName") val driverName: String
)