package com.thiago.mvinotes.core.domain.repository

import com.thiago.mvinotes.core.domain.model.NoteItem


interface NoteRepository {

    suspend fun upsertNote(noteItem: NoteItem)

    suspend fun deleteNote(noteItem: NoteItem)

    suspend fun getAllNotes(): List<NoteItem>

}