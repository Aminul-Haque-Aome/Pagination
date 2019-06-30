package com.remotearth.fake_coder.pagination.viewModels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.remotearth.fake_coder.pagination.contracts.PostListView
import com.remotearth.fake_coder.pagination.viewModels.PostListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {

    private var postListView: PostListView

    constructor(postListView: PostListView): super() {
        this.postListView = postListView
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            return PostListViewModel(postListView) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}