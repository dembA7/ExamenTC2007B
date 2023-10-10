package com.example.kotlin.examentc2007b.data

import com.example.kotlin.examentc2007b.data.network.MovieAPIClient
import com.example.kotlin.examentc2007b.data.network.model.MovieBase
import com.example.kotlin.examentc2007b.data.network.model.MovieObject
import retrofit2.Response


class MovieRepository {
    private val apiMovie = MovieAPIClient()

    suspend fun getMovieList(apiKey: String): List<MovieBase>? {
        val response: MovieObject? = apiMovie.getMovieList(100)
        return if (response != null) {
            response.results
        } else {
            null
        }
    }
}