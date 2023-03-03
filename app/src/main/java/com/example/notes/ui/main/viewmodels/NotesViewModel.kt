package com.example.notes.ui.main.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.notes.AddNote
import com.example.notes.domain.notes.DeleteNote
import com.example.notes.domain.notes.GetNotes
import com.example.notes.domain.notes.UpdateNote
import com.example.notes.domain.notes.model.Note
import com.example.notes.ui.main.interaction.NoteEvent
import com.example.notes.ui.main.interaction.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotes: GetNotes,
    private val addNote: AddNote,
    private val deleteNote: DeleteNote,
    private val updateNote: UpdateNote
) : ViewModel() {

    private val _state: MutableState<NoteState> = mutableStateOf(NoteState())
    val state: State<NoteState> get() = _state

    init {
        collectNotes()
    }

    fun onEvent(noteEvent: NoteEvent) {
        when(noteEvent) {
            is NoteEvent.AddNote -> {
                onInsertNote(noteEvent.note)
            }
            is NoteEvent.DeleteNote -> {
                onDeleteNote(noteEvent.note)
            }
            is NoteEvent.GetNotes -> {
                collectNotes()
            }
            is NoteEvent.UpdateNote -> {
                onUpdateNote(noteEvent.note)
            }
            is NoteEvent.SelectNote -> {
                onSelectNote(note = noteEvent.note)
            }
            is NoteEvent.UnNavToHome -> {
                notNavToHome()
            }
        }
    }

    private fun collectNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchedNotes = getNotes()
            Log.d("NOTES", fetchedNotes.toString())
            withContext(Dispatchers.Main) {
                _state.value = _state.value.copy(notes = fetchedNotes)
            }
        }
    }

    private fun onInsertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNote(note)
            collectNotes()
            onNavToHome()
        }
    }

    private fun onDeleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNote(note)
            collectNotes()
            onNavToHome()
        }
    }

    private fun onUpdateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            updateNote(note)
            collectNotes()
            onNavToHome()
        }
    }

    private fun onSelectNote(note: Note) {
        _state.value = _state.value.copy(selectedNote = note)
    }

    private fun onNavToHome() {
        _state.value = _state.value.copy(navToHome = true)
    }

    private fun notNavToHome() {
        _state.value = _state.value.copy(navToHome = false)
    }
}