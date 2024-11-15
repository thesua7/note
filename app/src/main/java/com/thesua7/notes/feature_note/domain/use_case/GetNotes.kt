package com.thesua7.notes.feature_note.domain.use_case

import com.thesua7.notes.feature_note.domain.model.Note
import com.thesua7.notes.feature_note.domain.repository.NoteRepository
import com.thesua7.notes.feature_note.domain.util.NoteOrder
import com.thesua7.notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val noteRepository: NoteRepository) {


    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {

        return noteRepository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedBy { it.color }

                    }

                }

                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedBy { it.color }

                    }
                }
            }
        }

    }
}