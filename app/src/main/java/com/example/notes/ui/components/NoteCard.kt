package com.example.notes.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.domain.notes.model.Note
import com.example.notes.ui.theme.NotesTheme

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onSelectNote: (note: Note) -> Unit
) {
    Card(modifier = modifier.clickable { onSelectNote(note) }, backgroundColor = MaterialTheme.colors.surface) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = note.title, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = note.body, maxLines = 3, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun FakeNoteCard() {
    NoteCard(note = Note(title = "Viaje al Sanatorio Durán", body = "- Llevar comida\n-Llevar agua"), onSelectNote = {})
}

@Preview
@Composable
fun NoteCardLightPreview() {
    NotesTheme {
        FakeNoteCard()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NoteCardDarkPreview() {
    NotesTheme {
        FakeNoteCard()
    }
}