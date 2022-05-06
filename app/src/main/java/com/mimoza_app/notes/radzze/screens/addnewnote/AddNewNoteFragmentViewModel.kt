package com.mimoza_app.notes.radzze.screens.addnewnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteFragmentViewModel(application: Application):AndroidViewModel(application) {

fun insert(note:AppNote,onSuccess:()->Unit){
    viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.insert(note){
        }
    }
    onSuccess()
}

}