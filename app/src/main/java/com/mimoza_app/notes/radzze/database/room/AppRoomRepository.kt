package com.mimoza_app.notes.radzze.database.room

import androidx.lifecycle.LiveData
import com.mimoza_app.notes.radzze.database.DatabaseRepository
import com.mimoza_app.notes.radzze.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao):DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
    }
}