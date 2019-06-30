package com.remotearth.fake_coder.pagination.viewModels.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    var isLoading = ObservableField<Boolean>()

    fun showLoader() {
        isLoading.set(true)
    }

    fun hideLoader() {
        isLoading.set(false)
    }
}