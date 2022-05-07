package com.mimoza_app.notes.radzze.database

import androidx.lifecycle.LiveData
import com.mimoza_app.notes.radzze.models.AppNote

interface DatabaseRepository {
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)
    fun signOut() {}
    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}
}