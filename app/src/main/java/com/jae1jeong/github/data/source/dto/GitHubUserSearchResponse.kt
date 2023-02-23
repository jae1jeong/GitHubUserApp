package com.jae1jeong.github.data.source.dto

data class GitHubUserSearchResponse(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
)


