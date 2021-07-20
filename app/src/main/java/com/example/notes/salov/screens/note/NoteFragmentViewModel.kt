package com.example.notes.salov.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.salov.model.AppNote
import com.example.notes.salov.utilits.REPOSITORIY
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun delete(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch {
            REPOSITORIY.delete(note) {
                onSuccess()
            }
        }
}