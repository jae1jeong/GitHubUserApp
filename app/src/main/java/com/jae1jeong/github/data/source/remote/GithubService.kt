package com.jae1jeong.github.data.source.remote

import com.jae1jeong.github.data.source.dto.GitHubUserDetailResponse
import com.jae1jeong.github.data.source.dto.GitHubUserSearchResponse
import com.jae1jeong.github.utlis.Resource
import com.jae1jeong.github.utlis.Routers
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Github API communication setup via Retrofit.
 */
interface GithubService {
    // search user by keyword
    @GET(Routers.SEARCH_USER)
    suspend fun searchUsers(@Query("q") query: String): Resource<GitHubUserSearchResponse>

    // user detail
    @GET(Routers.GET_USER)
    suspend fun getUser(@Query("username") username: String): Resource<GitHubUserDetailResponse>

    // user repos
    @GET(Routers.GET_REPOS)
    suspend fun getRepos(@Query("username") username: String): Nothing
}