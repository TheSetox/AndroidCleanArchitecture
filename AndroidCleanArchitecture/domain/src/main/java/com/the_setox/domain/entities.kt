package com.the_setox.domain

/**
 * Note Entity
 * @param id is the identifier to get/update/delete a note.
 * @param name is the title of the note.
 * @param description is the content description why the note is created.
 * @param notes is a record of anything that you want to save.
 */
data class Notes(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val notes: String = ""
)