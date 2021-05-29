package com.example.finema.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel

interface DatabaseRepository {
    val allGenres: LiveData<List<GenreModel>>

    val allFavourites: LiveData<List<MovieModel>>

    val allTop: LiveData<List<TopModel>>

    fun checkFavourite(movieId: Long): List<Long>

    suspend fun insert(genre: GenreModel, onSuccess: () -> Unit)

    suspend fun insertTop(movie: TopModel, onSuccess: () -> Unit)

    suspend fun insertFavourite(movie: MovieModel, onSuccess: () -> Unit)

    suspend fun deleteAllFavourite(onSuccess: () -> Unit)

    suspend fun deleteFavouriteMovie(movieId: Long, onSuccess: () -> Unit)

    suspend fun deleteFavourite(movie: MovieModel, onSuccess: () -> Unit)

    suspend fun deleteAllTop(onSuccess: () -> Unit)

    fun signOut(){}

}
