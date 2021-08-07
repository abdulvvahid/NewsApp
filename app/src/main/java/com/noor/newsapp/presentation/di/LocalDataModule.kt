package com.noor.newsapp.presentation.di

import com.noor.newsapp.data.db.ArticleDao
import com.noor.newsapp.data.repository.datasource.NewsLocalDataSource
import com.noor.newsapp.data.repository.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideNewsLocalDataSource(
        articleDao: ArticleDao
    ): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }

}