package com.thesua7.notes.feature_note.presentation.util

sealed class Screen(val route:String) {
    data object  NotesScreen:Screen("note_screen")
    data object  AddEditScreen:Screen("add_edit_note_screen")
}