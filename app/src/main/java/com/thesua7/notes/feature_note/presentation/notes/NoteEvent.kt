package com.thesua7.notes.feature_note.presentation.notes

import com.thesua7.notes.feature_note.domain.model.Note
import com.thesua7.notes.feature_note.domain.util.NoteOrder

sealed class NoteEvent {
    data class Order(val noteOrder: NoteOrder) : NoteEvent()
    data class DeleteNote(val note: Note) : NoteEvent()
    data object RestoreNote : NoteEvent()
    data object  ToggleOrderSection:NoteEvent()
}