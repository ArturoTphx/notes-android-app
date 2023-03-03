package com.example.notes.domain.notes

import com.example.notes.data.notes.NotesRepository
import com.example.notes.domain.notes.model.Note
import com.example.notes.domain.notes.model.toNoteEntity
import javax.inject.Inject

class AddNote @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(note: Note) {
        notesRepository.insert(note.toNoteEntity())
    }
}