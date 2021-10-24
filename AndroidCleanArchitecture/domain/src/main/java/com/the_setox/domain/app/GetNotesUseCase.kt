package com.the_setox.domain.app

import com.the_setox.domain.Notes
import com.the_setox.domain.NotesRepository

/**
 * A UseCase for Getting Notes.
 */
class GetNotesUseCase(repository: NotesRepository) : NotesUseCase(repository) {

    /**
     * Get the single notes.
     * @param id will be able to identify the notes that needed to be get.
     * @return [Notes] Object if the parameter id is identified.
     */
    operator fun invoke(id: Int): Notes {
        repository.getNotes(id).also {
            println("GetNotesUseCase: $id")
            return it
        }
    }
}