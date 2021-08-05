package com.noor.newsapp.presentation.di

import com.noor.newsapp.data.api.NewsAPIService
import com.noor.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.noor.newsapp.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}