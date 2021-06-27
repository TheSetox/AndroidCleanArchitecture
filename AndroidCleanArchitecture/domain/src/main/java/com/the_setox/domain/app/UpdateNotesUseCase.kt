package com.the_setox.domain.app

import com.the_setox.domain.Notes
import com.the_setox.domain.NotesRepository

/**
 * A UseCase for Updating Notes.
 */
class UpdateNotesUseCase(repository: NotesRepository) : NotesUseCase(repository) {

    /**
     * Update the notes.
     * @param notes is an Object of [Notes] that will be updated.
     * @return [Notes] Object that needs to be updated.
     */
    fun updateNotes(notes: Notes): Notes {
        repository.updateNotes(notes).also {
            println("UpdateNotesUseCase")
            return it
        }
    }
}