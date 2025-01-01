package com.thiago.mvinotes.note_list.domain.use_case

import com.thiago.mvinotes.core.domain.model.NoteItem
import com.thiago.mvinotes.core.domain.repository.NoteRepository

class GetAllNotes(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(
        isOrderByTitle: Boolean
    ): List<NoteItem> {
        return if (isOrderByTitle) {
            noteRepository.getAllNotes().sortedBy { it.title.lowercase() }
        } else {
            noteRepository.getAllNotes().sortedBy { it.dateAdded }
        }
    }

}