package com.example.notes.salov.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.salov.model.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notes_tables")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}