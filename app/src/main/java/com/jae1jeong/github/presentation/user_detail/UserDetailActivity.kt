package com.jae1jeong.github.presentation.user_detail

import androidx.activity.viewModels
import com.jae1jeong.github.R
import com.jae1jeong.github.databinding.ActivityUserDetailBinding
import com.jae1jeong.github.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity() : BaseActivity<ActivityUserDetailBinding,UserDetailViewModel>() {
    override val viewModel: UserDetailViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.activity_user_detail
    override fun initView() {

    }

    override fun observeData() {

    }

    override fun setEvent() {

    }

}