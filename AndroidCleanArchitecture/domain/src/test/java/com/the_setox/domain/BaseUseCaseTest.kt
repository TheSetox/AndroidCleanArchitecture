package com.the_setox.domain

import io.mockk.mockk
import io.mockk.spyk

/**
 * Create Base UseCase for Unit tests.
 */
open class BaseUseCaseTest {

    val repository = spyk<NotesRepository>()
    val notes = mockk<Notes>()

}