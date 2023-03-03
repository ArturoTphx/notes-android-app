package com.example.notes.utils

import com.example.notes.domain.notes.model.Note

object Constants {
    const val notes_database = "note"
    val fake_single_note = Note(title = "Viaje al Sanatorio Durán", body = "- Llevar comida\n- Llevar agua")
    val fake_notes_list = listOf(
        Note(title = "Viaje al Sanatorio Durán", body = "- Llevar comida\n- Llevar agua"),
        Note(title = "Viaje a Puntarenas", body = "- Llevar plata\n"),
        Note(title = "Sacar licencia", body = "- Pasar examen teórico\n- Pasar examen práctico")
    )
}