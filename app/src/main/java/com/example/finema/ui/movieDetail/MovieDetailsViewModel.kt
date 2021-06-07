package com.example.finema.ui.movieDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesRepository
import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.AppPreference
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val repository: MoviesRepository,
    private val dbRepository: RoomRepository
) : BaseViewModel() {

    private val fbRepository: FirebaseRepository = FirebaseRepository()
    var film = MutableLiveData<MovieDetails>()
    var arg: Long = 0
    var favouriteMovies: List<Long>? = null

    fun getMovieDetails() {
        job = Coroutines.ioThenMan(
            { repository.getMovieDetails(arg) },
            {
                film.value = it
                film.value!!.stringGenres = ""
                film.value!!.stringCompanies = ""

                for (item in it!!.genres) {
                    film.value!!.stringGenres += item.name + NEW_LINE
                }

                for (item in it.productionCompanies) {
                    film.value!!.stringCompanies += item.name + TAB + item.originCountry + NEW_LINE
                }

                Log.d("gypsy", "Details")
            }
        )
    }

    fun insert(movieModel: MovieModel) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.insertFavourite(movieModel) {
            }
        }
        if (AppPreference.getGuestOrAuth() == "AUTH") {
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.insertFirebaseFavouriteFilm(movieModel)
            }
        }
    }

    fun checkFavourite() {
        GlobalScope.launch {
            favouriteMovies = dbRepository.checkFavourite(arg)
            Log.d("gypsy", "Check")
            Log.d("gypsy", arg.toString())
        }
    }

    fun toTopModel(movieModel: MovieModel): TopModel {
        return TopModel(
            movieModel.id,
            movieModel.title,
            null,
            movieModel.about,
            null,
            movieModel.rating,
            null
        )
    }

    fun deleteMovie(id: Long, movie: MovieModel) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.deleteFavouriteMovie(id) {}
        }
        if (AppPreference.getGuestOrAuth() == "AUTH") {
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.deleteFirebaseFavouriteFilm(movie)
            }
        }
    }

    suspend fun addToTopMovies(movieModel: TopModel) {
        dbRepository.insertTop(movieModel) {}
    }

    companion object {
        const val NEW_LINE = "\n"
        const val TAB = "\t"
    }
}
