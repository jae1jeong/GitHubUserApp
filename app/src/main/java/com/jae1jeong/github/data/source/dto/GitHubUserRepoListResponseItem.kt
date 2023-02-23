package com.jae1jeong.github.data.source.dto

import com.google.gson.annotations.SerializedName

data class GitHubUserRepoListResponseItem(
    @SerializedName("allow_forking")
    val allowForking: Boolean,
    @SerializedName("archive_url")
    val archiveUrl: String,
    val archived: Boolean,
    @SerializedName("assignees_url")
    val assigneesUrl: String,
    @SerializedName("blobs_url")
    val blobsUrl: String,
    @SerializedName("branches_url")
    val branchesUrl: String,
    @SerializedName("clone_url")
    val cloneUrl: String,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    @SerializedName("commits_url")
    val commitsUrl: String,
    @SerializedName("compare_url")
    val compareUrl: String,
    @SerializedName("contents_url")
    val contentsUrl: String,
    @SerializedName("contributors_url")
    val contributorsUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("default_branch")
    val defaultBranch: String,
    @SerializedName("deployments_url")
    val deploymentsUrl: String,
    val description: String,
    val disabled: Boolean,
    @SerializedName("downloads_url")
    val downloadsUrl: String,
    @SerializedName("events_url")
    val eventsUrl: String,
    val fork: Boolean,
    val forks: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("forks_url")
    val forksUrl: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String,
    @SerializedName("git_url")
    val gitUrl: String,
    val homepage: String,
    val hooks_url: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val id: Long,
    val language: String,
    val name: String,
    @SerializedName("owner")
    val owner: User,
    @SerializedName("private")
    val isPrivate: Boolean,
    val size: Int,
    val updated_at: String,
    val url: String,
    val visibility: String,
    val watchers: Int,
    val watchers_count: Int,
)