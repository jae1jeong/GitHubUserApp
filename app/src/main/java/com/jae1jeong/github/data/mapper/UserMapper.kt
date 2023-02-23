package com.jae1jeong.github.data.mapper

import com.jae1jeong.github.data.source.dto.User
import com.jae1jeong.github.domain.model.user_list.UserUiModel


fun User.toUserUiModel() = UserUiModel(
    userId = id.toLong(),
    profileImage = avatar_url,
    userName = login
)