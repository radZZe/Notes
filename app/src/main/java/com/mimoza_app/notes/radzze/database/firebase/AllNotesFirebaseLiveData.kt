package com.mimoza_app.notes.radzze.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.REF_DATABASE

class AllNotesFirebaseLiveData() : LiveData<List<AppNote>>() {


    private val listener = object:ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map{
                it.getValue(AppNote::class.java)?:AppNote()
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    }


    override fun onActive() {
        REF_DATABASE.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        REF_DATABASE.removeEventListener(listener)
        super.onInactive()
    }

}