package com.example.kotlin.examentc2007b.data.network

import NetworkModuleDI

class MovieAPIClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit: Int): com.example.kotlin.examentc2007b.data.network.model.MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(apiKey = "b9be2700fb5f71275ab111aa356e75a9")
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}