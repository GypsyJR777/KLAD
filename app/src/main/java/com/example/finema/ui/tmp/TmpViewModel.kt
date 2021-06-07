package com.example.finema.ui.tmp

import androidx.lifecycle.viewModelScope
import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(
    private val dbRepository: RoomRepository,
    private val fbRepository: FirebaseRepository = FirebaseRepository()
) : BaseViewModel() {

    private val allMovies = fbRepository.allMovies

    init {
        fbRepository.initRefs()
    }

    fun initRoomFromFirebaseToRoom() {
        allMovies.observe(
            APP_ACTIVITY,
            { listMovie ->
                listMovie.map { it.id = it.idFirebase.toLong() }
                for (item in listMovie) {
                    viewModelScope.launch(Dispatchers.Main) {
                        dbRepository.insertFavourite(item) {}
                    }
                }
            }
        )
    }
}
