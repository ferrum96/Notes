package com.example.notes.salov.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.salov.utilits.REPOSITORIY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes = REPOSITORIY.allNotes
}