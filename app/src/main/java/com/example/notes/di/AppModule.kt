package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.data.notes.local.NoteDatabase
import com.example.notes.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesRoomDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, NoteDatabase::class.java, Constants.notes_database).build()

    @Provides
    @Singleton
    fun provideNotesDAO(notesDB: NoteDatabase) = notesDB.notesDao()
}