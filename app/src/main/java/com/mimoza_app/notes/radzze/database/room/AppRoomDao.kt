package com.mimoza_app.notes.radzze.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mimoza_app.notes.radzze.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)

    @Update
    suspend fun update(note:AppNote)

}