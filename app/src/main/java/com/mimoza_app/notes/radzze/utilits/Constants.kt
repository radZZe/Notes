package com.mimoza_app.notes.radzze.utilits

import com.mimoza_app.notes.radzze.MainActivity
import com.mimoza_app.notes.radzze.database.DatabaseRepository
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase

lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:DatabaseRepository
lateinit var EMAIL:String
lateinit var PASSWORD:String
const val TYPE_FIREBASE = "type_firebase"
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val KEY_CLICK_NOTE = "note"