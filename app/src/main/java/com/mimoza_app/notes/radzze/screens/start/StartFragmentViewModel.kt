package com.mimoza_app.notes.radzze.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mimoza_app.notes.radzze.database.firebase.AppFirebaseRepository
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase
import com.mimoza_app.notes.radzze.database.room.AppRoomRepository
import com.mimoza_app.notes.radzze.utilits.*

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({
                    onSuccess()
                }, {
                    showToast(it)
                })
            }
        }
    }
}