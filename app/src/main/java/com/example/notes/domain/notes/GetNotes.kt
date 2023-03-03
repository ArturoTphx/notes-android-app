package com.example.notes.domain.notes

import com.example.notes.data.notes.NotesRepository
import com.example.notes.domain.notes.model.Note
import com.example.notes.domain.notes.model.toNote
import javax.inject.Inject

class GetNotes @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(): List<Note> {
        return notesRepository.getAll().map { it.toNote() }
    }
}