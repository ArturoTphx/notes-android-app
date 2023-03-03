package com.example.notes.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.domain.notes.model.Note
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.utils.Constants

@Composable
fun NoteList(modifier: Modifier = Modifier, notes: List<Note>, onSelectNote: (note: Note) -> Unit) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 175.dp)
    ) {
        items(items = notes) { note->
            NoteCard(note = note, modifier = Modifier.padding(10.dp).height(100.dp).width(150.dp), onSelectNote = onSelectNote)
        }
    }
}

@Composable
fun FakeNoteList() {
    val notes = Constants.fake_notes_list
    NoteList(notes = notes, onSelectNote = {})
}

@Preview
@Composable
fun NoteListLightPreview() {
    NotesTheme {
        FakeNoteList()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NoteListDarkPreview() {
    NotesTheme {
       FakeNoteList()
    }
}