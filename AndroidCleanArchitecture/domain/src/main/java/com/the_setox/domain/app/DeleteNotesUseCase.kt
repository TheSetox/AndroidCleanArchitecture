package com.the_setox.domain.app

import com.the_setox.domain.NotesRepository

/**
 * A UseCase for Deleting Notes.
 */
class DeleteNotesUseCase(repository: NotesRepository) : NotesUseCase(repository) {

    /**
     * Delete the notes.
     * @param id will be able to identify the notes that will be deleted.
     * @return a string result if deleting the notes is successful.
     */
    operator fun invoke(id: Int): String {
        repository.deleteNotes(id).also {
            println("DeleteNotesUseCase: $it")
            return it
        }
    }
}