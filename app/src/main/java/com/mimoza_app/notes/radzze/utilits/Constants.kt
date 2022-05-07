package com.mimoza_app.notes.radzze.utilits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.mimoza_app.notes.radzze.MainActivity
import com.mimoza_app.notes.radzze.database.DatabaseRepository
import com.mimoza_app.notes.radzze.database.room.AppRoomDatabase

lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:DatabaseRepository
lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var AUTH:FirebaseAuth
lateinit var CURRENT_ID:String
lateinit var REF_DATABASE:DatabaseReference
const val TYPE_FIREBASE = "type_firebase"
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val KEY_CLICK_NOTE = "note"
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"