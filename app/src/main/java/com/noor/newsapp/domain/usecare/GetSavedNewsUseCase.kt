package com.noor.newsapp.domain.usecare

import com.noor.newsapp.data.model.Article
import com.noor.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(
    private val newsRepository: NewsRepository
) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}