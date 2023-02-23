package com.jae1jeong.github.presentation.user_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jae1jeong.github.R
import com.jae1jeong.github.databinding.ActivityUserlistBinding
import com.jae1jeong.github.presentation.base.BaseActivity

class UserListActivity: BaseActivity<ActivityUserlistBinding,UserListViewModel>(),BaseActivityBehavior {

    override val viewModel: UserListViewModel by viewModels()
    override val layoutResourceId: Int
        get() = R.layout.activity_userlist


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun initView() {

    }

    override fun observeData() {

    }

    override fun setEvent() {

    }

}