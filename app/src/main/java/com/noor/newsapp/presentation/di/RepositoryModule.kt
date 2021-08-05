package com.noor.newsapp.presentation.di

import com.noor.newsapp.data.repository.NewsRepositoryImpl
import com.noor.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.noor.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return  NewsRepositoryImpl(newsRemoteDataSource)
    }

}