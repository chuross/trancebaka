package com.github.chuross.trancebaka.infrastructure.android

import android.content.Context
import android.net.ConnectivityManager


object SystemUtils {

    fun getConnectivityManager(context: Context): ConnectivityManager? = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    fun checkNetworkConnected(context: Context): Boolean = getConnectivityManager(context)?.let {
        it.activeNetworkInfo.isConnected
    } ?: false
}