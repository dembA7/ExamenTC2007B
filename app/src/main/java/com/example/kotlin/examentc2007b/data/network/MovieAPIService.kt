package com.example.kotlin.examentc2007b.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {

    // API: https://api.themoviedb.org/3/movie/popular
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
    )
}