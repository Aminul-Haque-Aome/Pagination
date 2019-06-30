package com.remotearth.fake_coder.pagination.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.remotearth.fake_coder.pagination.databinding.ItemPostBinding
import com.remotearth.fake_coder.pagination.pojos.Post

class PostViewHolder(
    private val postView: ItemPostBinding
): RecyclerView.ViewHolder(postView.root) {

    fun bind(post: Post, onClickListener: (Post) -> Unit) {
        postView.post = post
        postView.root.setOnClickListener { onClickListener(post) }
    }

}