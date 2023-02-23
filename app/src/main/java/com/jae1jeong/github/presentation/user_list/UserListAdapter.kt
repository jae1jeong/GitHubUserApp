package com.jae1jeong.github.presentation.user_list

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jae1jeong.github.domain.model.user_list.UserUiModel

class UserListAdapter:PagingDataAdapter<UserUiModel,UserListAdapter.ViewHolder>( DIFF_CALLBACK ) {
    inner class ViewHolder(private val binding: ): RecyclerView.ViewHolder(binding.root) {

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
}