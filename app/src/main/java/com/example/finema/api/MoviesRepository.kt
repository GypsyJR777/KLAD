package com.example.finema.api

import com.example.finema.repositories.SafeApiRequest
import java.util.*

class MoviesRepository(
    private val api: MoviesApi = MoviesApi()
) : IMoviesRepository, SafeApiRequest() {

    override suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

    override suspend fun getGenres() = apiRequest {
        api.getGenreList()
    }

    //TODO запрос (20) -> liveData.value = response , local list add(response)
    //TODO запрос (20) -> local list add(response), liveData.value = list
    //TODO reducer почитать
    override suspend fun getMoviesWithGenre(page: Int, with_genres: String) = apiRequest {
        api.getMoviesWithGenre(page, with_genres)
    }

    override suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

}