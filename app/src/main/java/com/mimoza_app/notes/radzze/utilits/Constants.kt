package com.mimoza_app.notes.radzze.utilits

import com.mimoza_app.notes.radzze.MainActivity
import com.mimoza_app.notes.radzze.database.DatabaseRepository
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase

lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"