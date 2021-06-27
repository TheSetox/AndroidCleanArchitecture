package com.the_setox.data

import com.the_setox.domain.NotesRepository
import com.the_setox.domain.Notes

/**
 * A repository class just for Notes.
 */
class NotesDataRepository : DataRepository(), NotesRepository {

    override fun addNotes(notes: Notes): String {
        return "Added Notes"
    }

    override fun deleteNotes(id: Int): String {
        return "Deleted Notes"
    }

    override fun getNotes(id: Int): Notes {
        return Notes(id = "1")
    }

    override fun updateNotes(notes: Notes): Notes {
        return Notes(id = "2")
    }
}