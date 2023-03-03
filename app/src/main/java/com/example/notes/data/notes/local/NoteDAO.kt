package com.example.notes.data.notes.local

import androidx.room.*
import com.example.notes.utils.Constants

@Dao
interface NoteDAO {

    @Query("SELECT * FROM ${Constants.notes_database}")
    fun getAll(): List<NoteEntity>

    @Insert
    fun insert(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)
}