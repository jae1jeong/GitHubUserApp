package com.jae1jeong.github.di

import com.jae1jeong.github.presentation.user_list.UserListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideUserListAdapter() = UserListAdapter()
}