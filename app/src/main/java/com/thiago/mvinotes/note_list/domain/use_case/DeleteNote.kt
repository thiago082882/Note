package com.thiago.mvinotes.note_list.domain.use_case

import com.thiago.mvinotes.core.domain.model.NoteItem
import com.thiago.mvinotes.core.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: NoteItem) {
        noteRepository.deleteNote(note)
    }

}