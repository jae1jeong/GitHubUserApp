package com.jae1jeong.github.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jae1jeong.github.data.mapper.toUserUiModel
import com.jae1jeong.github.domain.model.user_list.UserUiModel
import retrofit2.HttpException

class UserListPagingSource(
    private val githubService: GithubService,
    private val query:String
):PagingSource<Int,UserUiModel>() {
    override fun getRefreshKey(state: PagingState<Int, UserUiModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserUiModel> {

        try{
            val page = params.key ?: 1
            val pageSize = params.loadSize

            val response = githubService.searchUsers(query,page,pageSize)
            val userList = response.data?.items?.map {
                it.toUserUiModel()
            } ?: return LoadResult.Error(NullPointerException("response.data.items is null"))

            return LoadResult.Page(
                data = userList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (userList.isEmpty()) null else page + 1
            )
        }catch (e:HttpException){
            return LoadResult.Error(e)
        }catch (e: Exception){
            return LoadResult.Error(e)
        }

    }
}