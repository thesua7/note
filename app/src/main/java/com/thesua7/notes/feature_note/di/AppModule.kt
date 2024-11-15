package com.thesua7.notes.feature_note.di

import android.app.Application
import androidx.room.Room
import com.thesua7.notes.feature_note.data.data_source.NoteDatabase
import com.thesua7.notes.feature_note.data.repository.NoteDataRepository
import com.thesua7.notes.feature_note.domain.repository.NoteRepository
import com.thesua7.notes.feature_note.domain.use_case.AddNote
import com.thesua7.notes.feature_note.domain.use_case.DeleteNote
import com.thesua7.notes.feature_note.domain.use_case.GetNote
import com.thesua7.notes.feature_note.domain.use_case.GetNotes
import com.thesua7.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteDataRepository(noteDatabase.noteDao)
    }

    @Singleton
    @Provides
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            addNote = AddNote(noteRepository),
            getNote = GetNote(noteRepository)

        )
    }
}