package com.example.testapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Price(
    @SerializedName("amount") val amount: Int,
    @SerializedName("currency") val currency: Currency
)