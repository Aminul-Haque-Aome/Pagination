package com.remotearth.fake_coder.pagination.screens.fragments.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.remotearth.fake_coder.pagination.R
import com.remotearth.fake_coder.pagination.contracts.base.BaseView
import com.remotearth.fake_coder.pagination.utils.ConnectivityUtil
import com.remotearth.fake_coder.pagination.utils.ProgressUtil

abstract class BaseFragment : Fragment(), BaseView {

    private var mContext: Context? = null
    private var progressUtil: ProgressUtil? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        progressUtil = ProgressUtil(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initDataBinding(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWidget()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        bundleCommunication()
    }

    override fun isInternetAvailable(): Boolean? {
        return ConnectivityUtil(mContext!!).isConnectedToInternet
    }

    override fun showToast(message: String) {
        mContext?.let { Toast.makeText(mContext, message, Toast.LENGTH_LONG).show() }
    }

    override fun showProgress(message: String) {
        progressUtil?.showProgressDialog(message)
    }

    override fun hideProgress() {
        progressUtil?.hideProgressDialog()
    }

    protected fun navigateTo(actionId: Int, bundle: Bundle? = null) {
        val navController = Navigation.findNavController(requireActivity(),
            R.id.nav_host_fragment
        )
        navController.navigate(actionId, bundle)
    }

    protected abstract fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    protected abstract fun initWidget()
    protected abstract fun initViewModel()
    protected abstract fun bundleCommunication()
}