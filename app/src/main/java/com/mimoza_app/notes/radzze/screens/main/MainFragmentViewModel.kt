package com.mimoza_app.notes.radzze.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mimoza_app.notes.radzze.utilits.REPOSITORY
import io.reactivex.internal.operators.single.SingleDoOnSuccess

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }
}