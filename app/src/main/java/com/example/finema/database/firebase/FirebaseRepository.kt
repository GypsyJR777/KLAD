package com.example.finema.database.firebase

import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.util.REF_DATABASE
import com.example.finema.util.REF_DATABASE_USER
import com.example.finema.util.REF_DATABASE_USER_SAVED
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository : IFirebaseRepository {
    override val allCategories: LiveData<List<CategoryModel>> = CategoriesLiveData()
    override val allMovies: LiveData<List<MovieModel>> = MoviesFromFirebaseLiveData()

    private val mAuth = FirebaseAuth.getInstance()
    private val mDatabaseReference = FirebaseDatabase.getInstance().reference

    override fun initRefCategory() {
        REF_DATABASE = mDatabaseReference
            .child("category")
    }

    override fun initRefs() {

        val currentId = mAuth.currentUser?.uid.toString()
        REF_DATABASE_USER = mDatabaseReference
            .child("user_list")
            .child(currentId)

        REF_DATABASE_USER_SAVED = REF_DATABASE_USER.child("saved")
    }

    override fun insertFirebaseFavouriteFilm(movieModel: MovieModel) {

        val fId = "idFirebase"
        val fTitle = "title"
        val fImageUrl = "imageUrl"
        val fAbout = "about"
        val fRating = "rating"

        val mapMovie = hashMapOf<String, Any>()
        mapMovie[fId] = movieModel.id.toString()
        mapMovie[fTitle] = movieModel.title
        mapMovie[fImageUrl] = movieModel.imageUrl.toString()
        mapMovie[fAbout] = movieModel.about
        mapMovie[fRating] = movieModel.rating

        REF_DATABASE_USER_SAVED.child(movieModel.id.toString())
            .updateChildren(mapMovie)
    }

    override fun deleteFirebaseFavouriteFilm(movieModel: MovieModel) {
        REF_DATABASE_USER_SAVED.child(movieModel.id.toString()).removeValue()
    }

    override fun clearFirebaseFavourite() {
        REF_DATABASE_USER_SAVED.removeValue()
    }
}
