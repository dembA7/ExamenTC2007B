package com.example.kotlin.examentc2007b.data.remote

import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.domain.model.MovieObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPIService {

    // API: https://api.themoviedb.org/3/movie/popular?api_key=
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
    ): MovieObject

    // API: https://api.themoviedb.org/3/movie/{movie_id}/images?api_key=
    @GET("movie/{movie_id}/images")
    suspend fun getMovieInfo(
        @Query("api_key") apiKey: String,
        @Path("movie_id") movieId: Int,
    ): MovieBase
}