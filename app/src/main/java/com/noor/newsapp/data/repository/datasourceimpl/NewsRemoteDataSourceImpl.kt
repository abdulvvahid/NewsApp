package com.noor.newsapp.data.repository.datasourceimpl

import com.noor.newsapp.data.api.NewsAPIService
import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
): NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }

}