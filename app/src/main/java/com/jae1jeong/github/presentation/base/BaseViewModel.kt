package com.jae1jeong.github.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel :ViewModel(){

    protected val _networkErrorEvent = MutableLiveData<Throwable?>()
    val networkErrorEvent get() = _networkErrorEvent

    protected val _loadingEvent = MutableLiveData<Boolean>()
    val loadingEvent get() = _loadingEvent


}