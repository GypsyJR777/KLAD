package com.example.finema

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation.findNavController
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.ui.settings.NotificationService
import com.example.finema.util.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.get
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit


//TODO добавить по аналогии
// findNavController(R.id.fragment_container)
//                    .addOnDestinationChangedListener { _, destination, _ ->
//                        if(SCREENS_WITHOUT_BOTTOM_BAR.contains(destination.id))
//                            binding.bottomBar.visibility = GONE
//                        else
//                            binding.bottomBar.visibility = VISIBLE
//                    }
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var simpleNotification = OneTimeWorkRequestBuilder<NotificationService>()
        .addTag("tag")
        .setInitialDelay(5, TimeUnit.SECONDS)
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        AppPreference.getPreference(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        checkUser()

        startKoin {
            androidContext(this@MainActivity)
            modules( listOf(
                apiModule,
                databaseModule,
                repositoryModule,
                viewModelModule
                )
            )
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {

                R.id.budget -> findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentHigherLower)

                R.id.tournament -> findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentTmp)

                R.id.settings -> findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentSettings)
            }

            true
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val notifications = sharedPreferences.getBoolean("notifications", true)

        if (notifications) {
            WorkManager.getInstance(this)
                .beginUniqueWork("notification", ExistingWorkPolicy.REPLACE, simpleNotification)
                .enqueue()
        }
    }

    private fun checkUser() {
        if (AppPreference.getInitUser()) {
            initDatabase(applicationContext, TYPE_ROOM) {
            }
        }
    }

    private fun initDatabase(context: Context, type:String, onSuccess:() -> Unit){
        when (type){
            TYPE_ROOM -> {
                onSuccess()
            }
        }
    }

}
