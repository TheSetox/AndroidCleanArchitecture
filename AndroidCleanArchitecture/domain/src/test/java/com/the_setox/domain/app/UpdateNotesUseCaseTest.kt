package com.the_setox.domain.app

import com.the_setox.domain.BaseUseCaseTest
import com.the_setox.domain.NotesRepository
import com.the_setox.domain.Notes
import io.mockk.every
import io.mockk.verifyAll
import org.junit.Assert

import org.junit.Before
import org.junit.Test

/**
 * Unit test for [UpdateNotesUseCase].
 */
class UpdateNotesUseCaseTest : BaseUseCaseTest() {

    lateinit var useCase: UpdateNotesUseCase

    /**
     * Initialize [UpdateNotesUseCase] using the stub of [NotesRepository].
     */
    @Before
    fun setUp() {
        useCase = UpdateNotesUseCase(repository)
    }

    /**
     * Verify if updateNotes can update the notes successfully.
     *
     * Pre-condition:
     * - Return a Single Notes Object from [NotesRepository].
     * Post-condition:
     * - Expected value is equal to pre-condition.
     * - Verify updateNotes of [UpdateNotesUseCase] and updatesNotes of [NotesRepository] is called.
     */
    @Test
    fun testUpdateNotesSuccess() {
        every { repository.updateNotes(notes) } returns Notes(id = "1")

        Assert.assertEquals(Notes(id = "1"), useCase.updateNotes(notes))
        verifyAll {
            useCase.updateNotes(notes)
            repository.updateNotes(notes)
        }
    }

    /**
     * Verify if updateNotes will return null values.
     *
     * Pre-condition:
     * - Any object needed is not initialize or null.
     * Post-condition:
     * - Expected value is equal to null.
     * - Verify updateNotes of [UpdateNotesUseCase] and updatesNotes of [NotesRepository] is called.
     */
    @Test
    fun testUpdateNotesNull() {
        Assert.assertNull(useCase.updateNotes(notes))
        //TODO("repository should not be called")
        verifyAll {
            useCase.updateNotes(notes)
            repository.updateNotes(notes)
        }
    }
}