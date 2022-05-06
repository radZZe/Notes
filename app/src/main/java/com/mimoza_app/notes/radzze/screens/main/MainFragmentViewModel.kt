package com.mimoza_app.notes.radzze.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mimoza_app.notes.radzze.utilits.REPOSITORY

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}