package com.jae1jeong.github.presentation.user_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jae1jeong.github.data.source.remote.GithubService
import com.jae1jeong.github.data.source.remote.UserListPagingSource
import com.jae1jeong.github.domain.model.user_list.UserUiModel
import com.jae1jeong.github.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val githubService: GithubService
):BaseViewModel() {

    companion object{
        const val PAGE_LIMIT = 20
    }

    fun getUsersByKeyword(keyword:String): Flow<PagingData<UserUiModel>> {
        _loadingEvent.value   = true
        return Pager(PagingConfig(PAGE_LIMIT)){
            _loadingEvent.value = false
            UserListPagingSource(githubService = githubService, query = keyword)
        }.flow.cachedIn(viewModelScope)
    }

}