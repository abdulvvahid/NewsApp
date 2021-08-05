package com.noor.newsapp.data.repository.datasourceimpl

import com.noor.newsapp.data.api.NewsAPIService
import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

}