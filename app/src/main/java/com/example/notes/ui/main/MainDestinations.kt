package com.example.notes.ui.main

sealed class MainDestinations(
    val route: String
) {
    object Home: MainDestinations("home")
    object Add: MainDestinations("add")
    object Update: MainDestinations("update")
}
