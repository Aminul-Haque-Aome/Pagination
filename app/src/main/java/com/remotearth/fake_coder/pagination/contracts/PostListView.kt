package com.remotearth.fake_coder.pagination.contracts

import com.remotearth.fake_coder.pagination.contracts.base.BaseView

interface PostListView: BaseView {
    fun onActionFailed(error: String)
}