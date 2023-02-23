package com.jae1jeong.github.presentation.user_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jae1jeong.github.R
import com.jae1jeong.github.databinding.ActivityUserlistBinding
import com.jae1jeong.github.presentation.base.BaseActivity
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import reactivecircus.flowbinding.android.widget.textChanges

class UserListActivity: BaseActivity<ActivityUserlistBinding,UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModels()
    override val layoutResourceId: Int
        get() = R.layout.activity_userlist


    override fun onCreate(savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

    }

    override fun observeData() {

    }

    override fun setEvent() {
        binding.etSearchUser.textChanges()
            .debounce(500)
            .filter { !it.toString().isNullOrEmpty() }
            .onEach {
                lifecycleScope.launch {
                    viewModel.getUsersByKeyword(it.toString())
                }
            }.launchIn(lifecycleScope)
    }

}