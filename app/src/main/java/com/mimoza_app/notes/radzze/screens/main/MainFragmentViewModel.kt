package com.mimoza_app.notes.radzze.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mimoza_app.notes.radzze.database.firebase.AppFirebaseRepository
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase
import com.mimoza_app.notes.radzze.database.room.AppRoomRepository
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.REPOSITORY
import com.mimoza_app.notes.radzze.utilits.TYPE_FIREBASE
import com.mimoza_app.notes.radzze.utilits.TYPE_ROOM
import com.mimoza_app.notes.radzze.utilits.showToast
import io.reactivex.internal.operators.single.SingleDoOnSuccess

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var mContext = application
    lateinit var allNotes: LiveData<List<AppNote>>

    fun initDatabase(type: String) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                allNotes = REPOSITORY.allNotes
            }
        }
    }
}