package com.example.finema.database.firebase

import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.models.databaseModels.MovieModel

interface IFirebaseRepository {
    val allCategories: LiveData<List<CategoryModel>>
    val allMovies: LiveData<List<MovieModel>>

    fun initRefCategory()

    fun initRefs()

    fun insertFirebaseFavouriteFilm(movieModel: MovieModel)

    fun deleteFirebaseFavouriteFilm(movieModel: MovieModel)

    fun clearFirebaseFavourite()
}