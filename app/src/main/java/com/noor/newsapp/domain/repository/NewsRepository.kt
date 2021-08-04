package com.noor.newsapp.domain.repository

import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.model.Article
import com.noor.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}