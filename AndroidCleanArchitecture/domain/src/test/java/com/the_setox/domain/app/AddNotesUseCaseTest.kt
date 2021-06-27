package com.the_setox.domain.app

import com.the_setox.domain.BaseUseCaseTest
import com.the_setox.domain.NotesRepository
import io.mockk.every
import io.mockk.verifyAll
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

import org.junit.Before


/**
 * Unit test for [AddNotesUseCase].
 */
class AddNotesUseCaseTest: BaseUseCaseTest() {

    lateinit var useCase: AddNotesUseCase

    /**
     * Initialize [AddNotesUseCase] using the stub of [NotesRepository].
     */
    @Before
    fun setUp() {
        useCase = AddNotesUseCase(repository)
    }

    /**
     * Verify if addNotes can add the notes successfully.
     *
     * Pre-condition:
     * - Return a Success Message from [NotesRepository].
     * Post-condition:
     * - Expected value is successful.
     * - Verify addNotes of [AddNotesUseCase] and addNotes of [NotesRepository] is called.
     */
    @Test
    fun testAddNotesSuccess() {
        every { repository.addNotes(notes) } returns "Success"

        assertEquals("Success", useCase.addNotes(notes))
        verifyAll {
            useCase.addNotes(notes)
            repository.addNotes(notes)
        }
    }

    /**
     * Verify if addNotes cannot add the notes.
     *
     * Pre-condition:
     * - Return an error Message from [NotesRepository].
     * Post-condition:
     * - Expected value is successful.
     * - Verify addNotes of [AddNotesUseCase] and addNotes of [NotesRepository] is called.
     */
    @Test
    fun testAddNotesError() {
        every { repository.addNotes(notes) } returns "Error"

        assertEquals("Error", useCase.addNotes(notes))
        verifyAll {
            useCase.addNotes(notes)
            repository.addNotes(notes)
        }
    }

    /**
     * Verify if addNotes will return null values.
     *
     * Pre-condition:
     * - Any object needed is not initialize or null.
     * Post-condition:
     * - Expected value is equal to null.
     * - Verify updateNotes of [AddNotesUseCase] and updatesNotes of [NotesRepository] is called.
     */
    @Test
    fun testAddNotesNull() {
        assertNull(useCase.addNotes(notes))
        //TODO("repository should not be called")
        verifyAll {
            useCase.addNotes(notes)
            repository.addNotes(notes)
        }
    }
}