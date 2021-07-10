package com.example.notes.salov.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_tables")
data class AppNote(val any: Any) {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    @ColumnInfo val name: String = ""
    @ColumnInfo val text: String = ""
}