package com.remotearth.fake_coder.pagination.screens.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.remotearth.fake_coder.pagination.R
import com.remotearth.fake_coder.pagination.adapters.PostAdapter
import com.remotearth.fake_coder.pagination.contracts.PostListView
import com.remotearth.fake_coder.pagination.databinding.FragmentUserListBinding
import com.remotearth.fake_coder.pagination.screens.fragments.base.BaseFragment
import com.remotearth.fake_coder.pagination.utils.config.Constant
import com.remotearth.fake_coder.pagination.viewModels.PostListViewModel
import com.remotearth.fake_coder.pagination.viewModels.factories.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : BaseFragment(), PostListView {

    private lateinit var viewModel: PostListViewModel
    private lateinit var binding: FragmentUserListBinding
    private lateinit var postAdapter: PostAdapter

    override fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        return binding.root
    }

    override fun initWidget() {
        postAdapter = PostAdapter {
            val bundle = Bundle()
            bundle.putParcelable(Constant.BUNDLE_POST, it)
        }

        postRecyclerView.adapter = postAdapter
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                this
            )
        ).get(PostListViewModel::class.java)

        binding.postListViewModel = viewModel
        viewModel.posts.observe(this, Observer { postAdapter.submitList(it) })

    }

    override fun bundleCommunication() {

    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchTodoList()
    }

    override fun onActionFailed(error: String) {
        showToast(error)
    }

}
