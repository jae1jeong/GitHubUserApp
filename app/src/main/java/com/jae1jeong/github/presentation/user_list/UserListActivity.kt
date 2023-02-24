package com.jae1jeong.github.presentation.user_list

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.jae1jeong.github.R
import com.jae1jeong.github.databinding.ActivityUserlistBinding
import com.jae1jeong.github.presentation.base.BaseActivity
import com.jae1jeong.github.utlis.decoration.UserListDividerDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import reactivecircus.flowbinding.android.widget.textChanges
import javax.inject.Inject

@AndroidEntryPoint
class UserListActivity: BaseActivity<ActivityUserlistBinding,UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModels()
    override val layoutResourceId: Int
        get() = R.layout.activity_userlist

    @Inject lateinit var userListAdapter:UserListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun initView() {
        binding.rvSearchUsers.apply {
            setHasFixedSize(true)
            adapter = userListAdapter
            addItemDecoration(UserListDividerDecoration(2))
        }
    }

    override fun observeData() {
        viewModel.loadingEvent.observe(this){
            if(it){

            }else{

            }
        }
    }

    override fun setEvent() {
        binding.etSearchUser.textChanges()
            .debounce(500)
            .map {
                if(it.isNullOrEmpty()){
                    userListAdapter.submitData(lifecycle, PagingData.empty())
                }else it
            }
            .filter { !it.toString().isNullOrEmpty() }
            .onEach {
                lifecycleScope.launch {
                    viewModel.getUsersByKeyword(it.toString()).collect {
                        userListAdapter.submitData(it)
                    }
                }
            }.launchIn(lifecycleScope)
    }

}