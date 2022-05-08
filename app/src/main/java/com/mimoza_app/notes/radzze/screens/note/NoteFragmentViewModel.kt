package com.mimoza_app.notes.radzze.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mimoza_app.notes.radzze.models.AppNote
import com.mimoza_app.notes.radzze.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application):AndroidViewModel(application) {

    fun deleteItem(note: AppNote,onSuccess:()->Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(note){}
        }
        onSuccess()
    }

    fun updateItem(note:AppNote,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.update(note){}
        }
        onSuccess()
    }
}