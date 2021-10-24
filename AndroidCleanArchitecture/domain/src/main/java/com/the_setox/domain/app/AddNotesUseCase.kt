package com.the_setox.domain.app

import com.the_setox.domain.Notes
import com.the_setox.domain.NotesRepository

/**
 * A UseCase for Adding Notes.
 */
class AddNotesUseCase(repository: NotesRepository) : NotesUseCase(repository) {

    /**
     * Add the notes.
     * @param notes is an Object of [Notes] that will be added.
     * @return a string result if adding the notes is successful.
     */
    operator fun invoke(notes: Notes): String {
        repository.addNotes(notes).also {
            println("AddNotesUseCase: $it")
            return it
        }
    }
}