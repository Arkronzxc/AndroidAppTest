package com.example.testapp.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city") val city: String,
    @SerializedName("address") val address: String
)