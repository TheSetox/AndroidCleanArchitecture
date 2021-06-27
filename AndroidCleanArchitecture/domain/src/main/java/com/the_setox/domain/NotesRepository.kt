package com.the_setox.domain

/**
 * Interface for NoteRepository.
 */
interface NotesRepository: Repository {

    /**
     * Add the notes.
     * @param notes is an Object of [Notes] that will be added.
     * @return a string result if adding the notes is successful.
     */
    fun addNotes(notes: Notes): String

    /**
     * Delete the notes.
     * @param id will be able to identify the notes that will be deleted.
     * @return a string result if deleting the notes is successful.
     */
    fun deleteNotes(id: Int): String

    /**
     * Get the single notes.
     * @param id will be able to identify the notes that needed to be get.
     * @return [Notes] Object if the parameter id is identified.
     */
    fun getNotes(id: Int): Notes

    /**
     * Update the notes.
     * @param notes is an Object of [Notes] that will be updated.
     * @return [Notes] Object that needs to be updated.
     */
    fun updateNotes(notes: Notes): Notes
}