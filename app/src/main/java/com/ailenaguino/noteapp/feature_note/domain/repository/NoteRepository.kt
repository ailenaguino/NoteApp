package com.ailenaguino.noteapp.feature_note.domain.repository

import com.ailenaguino.noteapp.feature_note.data.data_source.NoteDao
import com.ailenaguino.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository{
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}