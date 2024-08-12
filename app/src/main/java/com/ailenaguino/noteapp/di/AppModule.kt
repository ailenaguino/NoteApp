package com.ailenaguino.noteapp.di

import android.app.Application
import androidx.room.Room
import com.ailenaguino.noteapp.NoteApp
import com.ailenaguino.noteapp.feature_note.data.data_source.NoteDatabase
import com.ailenaguino.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.ailenaguino.noteapp.feature_note.domain.repository.NoteRepository
import com.ailenaguino.noteapp.feature_note.domain.usecases.DeleteNoteUseCase
import com.ailenaguino.noteapp.feature_note.domain.usecases.GetNotesUseCase
import com.ailenaguino.noteapp.feature_note.domain.usecases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository = NoteRepositoryImpl(db.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }
}