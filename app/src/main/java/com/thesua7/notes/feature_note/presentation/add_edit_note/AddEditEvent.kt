package com.thesua7.notes.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed class AddEditEvent {
    data class EnteredTitle(val value: String) : AddEditEvent()
    data class ChangeTitleFocused(val focusState:FocusState):AddEditEvent()
    data class EnteredContent(val value:String) : AddEditEvent()
    data class ChangeContentFocused(val focusState:FocusState):AddEditEvent()
    data class ChangeColor(val color:Int):AddEditEvent()
    data object SaveNote:AddEditEvent()

}