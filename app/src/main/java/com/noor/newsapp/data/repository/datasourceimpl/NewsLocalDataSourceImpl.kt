package com.noor.newsapp.data.repository.datasourceimpl

import com.noor.newsapp.data.db.ArticleDao
import com.noor.newsapp.data.model.Article
import com.noor.newsapp.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) = articleDao.insert(article)

    override fun getSavedArticleFromDB(): Flow<List<Article>> = articleDao.getAllArticles()

    override suspend fun deleteArticleFromDB(article: Article) = articleDao.deleteArticle(article)
}