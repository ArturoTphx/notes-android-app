package com.example.notes.ui.main.interaction

import com.example.notes.domain.notes.model.Note

sealed class NoteEvent {
    object GetNotes: NoteEvent()
    data class AddNote(val note: Note): NoteEvent()
    data class DeleteNote(val note: Note): NoteEvent()
    data class UpdateNote(val note: Note): NoteEvent()
    data class SelectNote(val note: Note): NoteEvent()
    object UnNavToHome: NoteEvent()
}