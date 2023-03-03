package com.example.notes.domain.notes.model

import com.example.notes.data.notes.local.NoteEntity

data class Note(
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
)

fun Note.toNoteEntity(): NoteEntity = NoteEntity(uid = id, title = title, body = body)
fun NoteEntity.toNote(): Note = Note(id = uid, title = title, body = body)