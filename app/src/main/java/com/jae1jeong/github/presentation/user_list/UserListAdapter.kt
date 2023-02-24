package com.jae1jeong.github.presentation.user_list

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jae1jeong.github.R
import com.jae1jeong.github.databinding.ItemUserBinding
import com.jae1jeong.github.domain.model.user_list.UserUiModel

class UserListAdapter : PagingDataAdapter<UserUiModel, UserListAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun onBind(item: UserUiModel){
                binding.user = item
                Log.d("TAG", "onBind: $item")
            }
        }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserUiModel>() {
            override fun areItemsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = snapshot()[position]
        item?.let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        val binding = ItemUserBinding.bind(view)
        return ViewHolder(binding)
    }
}