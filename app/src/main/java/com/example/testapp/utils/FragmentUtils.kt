package com.example.testapp.utils

import android.R
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentUtils {
    @JvmOverloads
    fun changeFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager?,
        containerId: Int,
        toBackStack: String? = null
    ) {
        if (fragmentManager == null) {
            return
        }
        val transaction = fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(containerId, fragment)
        if (!TextUtils.isEmpty(toBackStack)) {
            transaction.addToBackStack(toBackStack)
        }
        transaction.commit()
    }

    fun popStack(fragmentManager: FragmentManager?) {
        if (fragmentManager == null) {
            return
        }
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        }
    }
}