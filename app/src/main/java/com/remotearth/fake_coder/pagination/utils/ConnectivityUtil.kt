package com.remotearth.fake_coder.pagination.utils

import android.content.Context
import android.net.ConnectivityManager

class ConnectivityUtil(private var context: Context) {

    val isConnectedToInternet: Boolean?
        get() {
            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return manager.activeNetworkInfo != null && manager.activeNetworkInfo.isConnected
        }
}