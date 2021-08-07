package com.noor.newsapp.data.repository

import com.noor.newsapp.data.model.APIResponse
import com.noor.newsapp.data.model.Article
import com.noor.newsapp.data.repository.datasource.NewsLocalDataSource
import com.noor.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.noor.newsapp.data.util.Resource
import com.noor.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> = newsLocalDataSource.getSavedArticleFromDB()

    override suspend fun deleteNews(article: Article) = newsLocalDataSource.deleteArticleFromDB(article)
}