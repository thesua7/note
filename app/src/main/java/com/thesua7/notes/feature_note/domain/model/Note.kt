package com.thesua7.notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thesua7.notes.ui.theme.BabyBlue
import com.thesua7.notes.ui.theme.LightBlue
import com.thesua7.notes.ui.theme.LightGreen
import com.thesua7.notes.ui.theme.RedOrange
import com.thesua7.notes.ui.theme.RedPink
import com.thesua7.notes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(BabyBlue, RedOrange, Violet, LightGreen, RedPink)
    }
}


class InvalidNoteException(message: String) : Exception(message)