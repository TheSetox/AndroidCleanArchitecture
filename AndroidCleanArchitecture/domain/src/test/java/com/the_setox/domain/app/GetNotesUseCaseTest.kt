package com.the_setox.domain.app

import com.the_setox.domain.BaseUseCaseTest
import com.the_setox.domain.Notes
import com.the_setox.domain.NotesRepository
import io.mockk.every
import io.mockk.verifyAll
import org.junit.Assert

import org.junit.Before
import org.junit.Test

/**
 * Unit test for [GetNotesUseCase].
 */
class GetNotesUseCaseTest : BaseUseCaseTest() {

    lateinit var useCase: GetNotesUseCase

    /**
     * Initialize [GetNotesUseCase] using the stub of [NotesRepository].
     */
    @Before
    fun setUp() {
        useCase = GetNotesUseCase(repository)
    }

    /**
     * Verify if getNotes can get the notes successfully.
     *
     * Pre-condition:
     * - Return a Single Notes Object from [NotesRepository] if id is any.
     * Post-condition:
     * - Expected value is successful when Notes Object id is 1.
     * - Verify getNotes of [GetNotesUseCase] and getNotes of [NotesRepository] is called.
     */
    @Test
    fun testGetNotesSuccess() {
        every { repository.getNotes(any()) } returns Notes(id = "1")

        Assert.assertEquals(Notes(id = "1"), useCase.getNotes(1))
        verifyAll {
            useCase.getNotes(1)
            repository.getNotes(1)
        }
    }

    /**
     * Verify if getNotes will return null values.
     *
     * Pre-condition:
     * - Any object needed is not initialize or null when id is 2.
     * Post-condition:
     * - Expected value is equal to null when id is 2.
     * - Verify getNotes of [GetNotesUseCase] and getNotes of [NotesRepository] is called.
     */
    @Test
    fun testGetNotesNull() {
        Assert.assertNull(useCase.getNotes(2))
        //TODO("repository should not be called")
        verifyAll {
            useCase.getNotes(2)
            repository.getNotes(2)
        }
    }
}