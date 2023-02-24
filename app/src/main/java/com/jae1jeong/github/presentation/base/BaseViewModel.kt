package com.jae1jeong.github.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jae1jeong.github.presentation.livedata.SingleLiveEvent

open class BaseViewModel :ViewModel(){

    protected val _networkErrorEvent = SingleLiveEvent<Throwable?>()
    val networkErrorEvent get() = _networkErrorEvent

    protected val _loadingEvent = SingleLiveEvent<Boolean>()
    val loadingEvent get() = _loadingEvent


}