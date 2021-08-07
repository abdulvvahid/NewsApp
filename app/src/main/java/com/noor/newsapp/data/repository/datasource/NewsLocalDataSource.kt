package com.noor.newsapp.data.repository.datasource

import com.noor.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticleFromDB(): Flow<List<Article>>
    suspend fun deleteArticleFromDB(article: Article)

}