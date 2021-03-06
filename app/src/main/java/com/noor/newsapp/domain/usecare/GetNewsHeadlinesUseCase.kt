package com.noor.newsapp.domain.usecare

import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.util.Resource
import com.noor.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(
    private val newsRepository: NewsRepository
) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}