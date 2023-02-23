package com.jae1jeong.github.presentation.user_list

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jae1jeong.github.databinding.ItemUserBinding
import com.jae1jeong.github.domain.model.user_list.UserUiModel

class UserListAdapter : PagingDataAdapter<UserUiModel, UserListAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
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
        holder.binding.user = snapshot()[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}