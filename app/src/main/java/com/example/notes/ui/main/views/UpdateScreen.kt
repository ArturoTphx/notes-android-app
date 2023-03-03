package com.example.notes.ui.main.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.domain.notes.model.Note
import com.example.notes.ui.main.MainDestinations
import com.example.notes.ui.main.interaction.NoteEvent
import com.example.notes.ui.main.interaction.NoteState
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.utils.Constants

@Composable
fun UpdateScreen(
    selectedNote: Note,
    onNavigate: (MainDestinations) -> Unit,
    noteState: NoteState,
    onEvent: (noteEvent: NoteEvent) -> Unit
) {
    var title by remember { mutableStateOf(selectedNote.title) }
    var body by remember { mutableStateOf(selectedNote.body) }
    if(noteState.navToHome) {
        onNavigate(MainDestinations.Home)
        onEvent(NoteEvent.UnNavToHome)
    }
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { newText ->
                    title = newText
                },
                label = { Text("Title") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = body,
                onValueChange = { newText ->
                    body = newText
                },
                label = { Text("Body") },
                maxLines = 50
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {
                    onEvent(NoteEvent.UpdateNote(note = Note(id = selectedNote.id, title = title, body = body)))
                }) {
                    Icon(
                        Icons.Filled.Done,
                        contentDescription ="Done",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Update!")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = {
                    onEvent(
                        NoteEvent.DeleteNote(
                            note = Note(
                                id = selectedNote.id,
                                title = title,
                                body = body
                            )
                        )
                    )
                }) {
                    Text("Delete")
                }
            }

        }
    }
}

@Composable
fun FakeUpdateScreen() {
    UpdateScreen(selectedNote = Constants.fake_single_note, noteState = NoteState(), onNavigate = {}, onEvent = {})
}

@Preview
@Composable
fun UpdateLightPreview() {
    NotesTheme {
        FakeUpdateScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun UpdateDarkPreview() {
    NotesTheme {
        FakeUpdateScreen()
    }
}