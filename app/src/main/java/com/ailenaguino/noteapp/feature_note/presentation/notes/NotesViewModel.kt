package com.ailenaguino.noteapp.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.ailenaguino.noteapp.feature_note.domain.usecases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteUseCases: NoteUseCases): ViewModel() {
}