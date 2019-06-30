package com.remotearth.fake_coder.pagination.contracts

interface BaseView {
    fun isInternetAvailable(): Boolean?
    fun showToast(message: String)
    fun showProgress(message: String)
    fun hideProgress()
}