package com.thiago.mvinotes.core.data.repository

import com.thiago.mvinotes.core.data.local.NoteDb
import com.thiago.mvinotes.core.data.mapper.toNoteEntityForDelete
import com.thiago.mvinotes.core.data.mapper.toNoteEntityForInsert
import com.thiago.mvinotes.core.data.mapper.toNoteItem
import com.thiago.mvinotes.core.domain.model.NoteItem
import com.thiago.mvinotes.core.domain.repository.NoteRepository


class NoteRepositoryImpl(
    noteDb: NoteDb
) : NoteRepository {

    private val noteDao = noteDb.noteDao

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteDao.deleteNoteEntity(noteItem.toNoteEntityForDelete())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNoteEntities().map { it.toNoteItem() }
    }
}