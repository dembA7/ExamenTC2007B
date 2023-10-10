package com.example.kotlin.examentc2007b.data.remote

import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.domain.model.MovieObject

class MovieAPIClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit: Int): MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(apiKey = "b9be2700fb5f71275ab111aa356e75a9")
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getMovieInfo(movieId: Int): MovieBase?{
        api = NetworkModuleDI()
        return try{
            api.getMovieInfo(apiKey = "b9be2700fb5f71275ab111aa356e75a9", movieId = movieId)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}