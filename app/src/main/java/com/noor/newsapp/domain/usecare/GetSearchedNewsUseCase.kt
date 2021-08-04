package com.noor.newsapp.domain.usecare

import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.util.Resource
import com.noor.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(
    private val newsRepository: NewsRepository
) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}