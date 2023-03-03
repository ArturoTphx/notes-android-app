package com.example.notes.ui.main.interaction

import com.example.notes.domain.notes.model.Note

data class NoteState(
    var selectedNote: Note = Note(),
    var notes: List<Note> = emptyList(),
    var navToHome: Boolean = false
)