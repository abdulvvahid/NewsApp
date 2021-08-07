package com.noor.newsapp.data.repository.datasource

import com.noor.newsapp.data.model.Article

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)
    //suspend fun getArticleFromDB(): List<Article>

}