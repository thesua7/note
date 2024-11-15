package com.thesua7.notes.feature_note.data.repository

import com.thesua7.notes.feature_note.data.data_source.NoteDao
import com.thesua7.notes.feature_note.domain.model.Note
import com.thesua7.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteDataRepository(private val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteByID(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}