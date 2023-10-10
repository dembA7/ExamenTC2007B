package com.example.kotlin.examentc2007b.data.network

import com.example.kotlin.examentc2007b.data.network.model.MovieObject
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {

    // API: https://api.themoviedb.org/3/movie/popular?api_key=
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
    ): MovieObject
}