package com.example.notes.data.notes

import com.example.notes.data.notes.local.NoteDAO
import com.example.notes.data.notes.local.NoteEntity
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val notesDAO: NoteDAO
) {
    suspend fun getAll(): List<NoteEntity> {
        return notesDAO.getAll()
    }
    suspend fun insert(noteEntity: NoteEntity) {
        notesDAO.insert(noteEntity)
    }
    suspend fun delete(noteEntity: NoteEntity) {
        notesDAO.delete(noteEntity)
    }
    suspend fun update(noteEntity: NoteEntity) {
        notesDAO.update(noteEntity)
    }
}