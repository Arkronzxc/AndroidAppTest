package com.example.testapp.utils

import android.app.ActivityManager
import android.content.Context
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso

object PicassoUtils {

    private var picasso: Picasso? = null
    fun getCustomPicasso(context: Context): Picasso? {
        if (picasso == null) {
            picasso =
                Picasso.Builder(context)
                    //set 10% of available app memory for image cache
                    .memoryCache(LruCache(getBytesForMemCache(context)))
                    .build()
        }
        return picasso
    }

    private fun getBytesForMemCache(context: Context, percent: Int = 10): Int {
        val mi = ActivityManager.MemoryInfo()
        val activityManager =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)
        val availableMemory = mi.availMem.toDouble()
        return (percent * availableMemory / 100).toInt()
    }
}