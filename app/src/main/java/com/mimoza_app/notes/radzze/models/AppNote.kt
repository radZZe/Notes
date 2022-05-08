package com.mimoza_app.notes.radzze.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "notes_tables")
data class AppNote(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo var name:String ="",
    @ColumnInfo var text:String ="",
    val idFirebase:String = ""
):Serializable
