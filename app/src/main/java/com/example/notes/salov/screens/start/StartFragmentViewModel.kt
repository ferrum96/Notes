package com.example.notes.salov.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notes.salov.database.room.AppRoomDatabase
import com.example.notes.salov.database.room.AppRoomRepository
import com.example.notes.salov.utilits.REPOSITORIY
import com.example.notes.salov.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDataBase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORIY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}