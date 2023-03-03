package com.example.notes.data.notes.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun notesDao(): NoteDAO
}