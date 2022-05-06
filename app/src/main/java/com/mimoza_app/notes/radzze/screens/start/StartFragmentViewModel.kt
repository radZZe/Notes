package com.mimoza_app.notes.radzze.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase
import com.mimoza_app.notes.radzze.database.room.AppRoomRepository
import com.mimoza_app.notes.radzze.utilits.APP_ACTIVITY
import com.mimoza_app.notes.radzze.utilits.REPOSITORY
import com.mimoza_app.notes.radzze.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String,onSuccess:()->Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}