package com.remotearth.fake_coder.pagination.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.remotearth.fake_coder.pagination.adapters.viewHolders.PostViewHolder
import com.remotearth.fake_coder.pagination.databinding.ItemPostBinding
import com.remotearth.fake_coder.pagination.pojos.Post

class PostAdapter(
    private val onClickListener: (Post) -> Unit
) : ListAdapter<Post, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) = (oldItem.id == newItem.id)
            override fun areContentsTheSame(oldItem: Post, newItem: Post) = (oldItem == newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(getItem(position)!!, onClickListener)
    }
}