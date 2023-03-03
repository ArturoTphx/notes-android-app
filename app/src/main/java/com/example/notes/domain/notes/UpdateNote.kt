package com.example.notes.domain.notes

import com.example.notes.data.notes.NotesRepository
import com.example.notes.domain.notes.model.Note
import com.example.notes.domain.notes.model.toNoteEntity
import javax.inject.Inject

class UpdateNote @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(note: Note) {
        notesRepository.update(note.toNoteEntity())
    }
}