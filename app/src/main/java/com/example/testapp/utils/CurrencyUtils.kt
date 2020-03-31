package com.example.testapp.utils

import java.text.DecimalFormat
import java.util.*

class CurrencyUtils {
    fun priceFormatter(amount: Int, currency: Currency): String {
        val countryCode = currency.toString().take(2)
        val nf = DecimalFormat.getCurrencyInstance(Locale("und", countryCode))
        nf.currency = currency
        val fractionalDig: Int = currency.defaultFractionDigits
        val wholePart = amount.toString().take(amount.toString().length - fractionalDig)
        val fractionalPart = amount.toString().takeLast(fractionalDig)
        val ans = ("$wholePart.$fractionalPart").toFloat()
        return nf.format(ans)
    }
}