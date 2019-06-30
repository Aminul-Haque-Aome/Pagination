package com.remotearth.fake_coder.pagination.screens.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.remotearth.fake_coder.pagination.R
import com.remotearth.fake_coder.pagination.screens.fragments.base.BaseFragment
import com.remotearth.fake_coder.pagination.viewModels.UserListViewModel

class UserListFragment : BaseFragment() {

    private lateinit var viewModel: UserListViewModel

    override fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun initWidget() {

    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
    }

    override fun bundleCommunication() {

    }

}
