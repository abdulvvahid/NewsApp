package com.noor.newsapp.domain.usecare

import com.noor.newsapp.data.model.Article
import com.noor.newsapp.domain.repository.NewsRepository

class SaveNewsUseCase(
    private val newsRepository: NewsRepository
) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}