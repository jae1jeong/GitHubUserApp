package com.jae1jeong.github.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jae1jeong.github.presentation.user_list.BaseActivityBehavior

abstract class BaseActivity<T:ViewDataBinding,VM:BaseViewModel>:AppCompatActivity(),BaseActivityBehavior {
    protected lateinit var binding:T
    protected abstract val viewModel:VM
    abstract val layoutResourceId:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutResourceId)
        binding.lifecycleOwner = this
        initView()
        observeData()
        setEvent()
    }
}