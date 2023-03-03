package com.example.notes.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.ui.main.interaction.NoteEvent
import com.example.notes.ui.main.viewmodels.NotesViewModel
import com.example.notes.ui.main.views.AddScreen
import com.example.notes.ui.main.views.HomeScreen
import com.example.notes.ui.main.views.UpdateScreen
import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                val notesViewModel: NotesViewModel = hiltViewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = MainDestinations.Home.route
                ) {
                    composable(MainDestinations.Home.route) {
                        HomeScreen(
                            onNavigate = { destination ->
                                navigate(
                                    navHostController = navController,
                                    destination = destination
                                )
                            },
                            noteState = notesViewModel.state.value
                        ) { note ->
                            notesViewModel.onEvent(NoteEvent.SelectNote(note = note))
                            navigate(
                                navHostController = navController,
                                destination = MainDestinations.Update
                            )
                        }
                    }
                    composable(MainDestinations.Add.route) {
                        AddScreen(
                            onNavigate = { destination ->
                                navigate(
                                    navHostController = navController,
                                    destination = destination
                                )
                            },
                            noteState = notesViewModel.state.value,
                            onEvent = { notesViewModel.onEvent(it) })
                    }
                    composable(MainDestinations.Update.route) {
                        UpdateScreen(
                            selectedNote = notesViewModel.state.value.selectedNote,
                            onNavigate = { destination ->
                                navigate(
                                    navHostController = navController,
                                    destination = destination
                                )
                            },
                            noteState = notesViewModel.state.value,
                            onEvent = { notesViewModel.onEvent(it) })
                    }
                }
            }
        }
    }

    private fun navigate(navHostController: NavHostController, destination: MainDestinations) {
        navHostController.navigate(destination.route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}