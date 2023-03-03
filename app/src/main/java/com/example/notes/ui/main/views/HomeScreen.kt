package com.example.notes.ui.main.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.domain.notes.model.Note
import com.example.notes.ui.components.NoteList
import com.example.notes.ui.main.MainDestinations
import com.example.notes.ui.main.interaction.NoteState
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.utils.Constants

@Composable
fun HomeScreen(
    onNavigate: (MainDestinations) -> Unit,
    noteState: NoteState,
    onSelectNote: (note: Note) -> Unit
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    onNavigate(MainDestinations.Add)
                },
                icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                },
                text = { Text("Add") }
            )
        }
    ) {
        NoteList(modifier = Modifier.padding(it), notes = noteState.notes, onSelectNote = onSelectNote)
    }
}

@Composable
fun FakeHomeScreen() {
    HomeScreen(onNavigate = {}, noteState = NoteState(notes = Constants.fake_notes_list)) {}
}

@Preview(showBackground = true)
@Composable
fun HomeLightPreview() {
    NotesTheme {
        FakeHomeScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeDarkPreview() {
    NotesTheme {
        FakeHomeScreen()
    }
}