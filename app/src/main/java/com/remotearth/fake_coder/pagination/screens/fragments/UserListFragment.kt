package com.remotearth.fake_coder.pagination.screens.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.remotearth.fake_coder.pagination.R
import com.remotearth.fake_coder.pagination.adapters.PostAdapter
import com.remotearth.fake_coder.pagination.screens.fragments.base.BaseFragment
import com.remotearth.fake_coder.pagination.utils.config.Constant
import com.remotearth.fake_coder.pagination.viewModels.UserListViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : BaseFragment() {

    private lateinit var viewModel: UserListViewModel
    private lateinit var postAdapter: PostAdapter

    override fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun initWidget() {
        postAdapter = PostAdapter {
            val bundle = Bundle()
            bundle.putParcelable(Constant.BUNDLE_POST, it)
        }

        postRecyclerView.adapter = postAdapter
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
    }

    override fun bundleCommunication() {

    }

}
