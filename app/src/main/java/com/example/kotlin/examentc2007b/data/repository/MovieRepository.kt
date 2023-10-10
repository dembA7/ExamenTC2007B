package com.example.kotlin.examentc2007b.data.repository

import com.example.kotlin.examentc2007b.data.remote.MovieAPIClient
import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.domain.model.MovieObject


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