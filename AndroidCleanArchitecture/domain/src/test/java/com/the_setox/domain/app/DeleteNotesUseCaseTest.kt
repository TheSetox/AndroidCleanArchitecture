package com.the_setox.domain.app

import com.the_setox.domain.BaseUseCaseTest
import com.the_setox.domain.NotesRepository
import io.mockk.every
import io.mockk.verifyAll
import org.junit.Assert

import org.junit.Before
import org.junit.Test

/**
 * Unit test for [DeleteNotesUseCase].
 */
class DeleteNotesUseCaseTest : BaseUseCaseTest() {

    lateinit var deleteNotesUseCase: DeleteNotesUseCase

    /**
     * Initialize [DeleteNotesUseCase] using the stub of [NotesRepository].
     */
    @Before
    fun setUp() {
        deleteNotesUseCase = DeleteNotesUseCase(repository)
    }

    /**
     * Verify if deleteNotes can delete the notes successfully.
     *
     * Pre-condition:
     * - Return a Success Message from [NotesRepository] if id is any.
     * Post-condition:
     * - Expected value is successful when id is 1.
     * - Verify deleteNotes of [DeleteNotesUseCase] and deleteNotes of [NotesRepository] is called.
     */
    @Test
    fun testDeleteNotesSuccess() {
        every { repository.deleteNotes(any()) } returns "Success"

        Assert.assertEquals("Success", deleteNotesUseCase(1))
        verifyAll {
            deleteNotesUseCase(1)
            repository.deleteNotes(1)
        }
    }

    /**
     * Verify if deleteNotes cannot delete the notes.
     *
     * Pre-condition:
     * - Return an Error Message from [NotesRepository] if id is 0.
     * Post-condition:
     * - Expected value is error when id is 0.
     * - Verify deleteNotes of [DeleteNotesUseCase] and deleteNotes of [NotesRepository] is called.
     */
    @Test
    fun testDeleteNotesError() {
        every { repository.deleteNotes(0) } returns "Error"

        Assert.assertEquals("Error", deleteNotesUseCase(0))
        verifyAll {
            deleteNotesUseCase(0)
            repository.deleteNotes(0)
        }
    }

    /**
     * Verify if deleteNotes will return null values.
     *
     * Pre-condition:
     * - Any object needed is not initialize or null when id is 2.
     * Post-condition:
     * - Expected value is equal to null when id is 2.
     * - Verify deleteNotes of [DeleteNotesUseCase] and deleteNotes of [NotesRepository] is called.
     */
    @Test
    fun testDeleteNotesNull() {
        Assert.assertNull(deleteNotesUseCase(2))
        //TODO("repository should not be called")
        verifyAll {
            deleteNotesUseCase(2)
            repository.deleteNotes(2)
        }
    }
}