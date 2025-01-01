package com.thiago.mvinotes.add_note.domain.use_case




import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.thiago.mvinotes.core.data.repository.FakeNoteRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class UpsertNoteTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var fakeNotesRepositoryImpl: FakeNoteRepository
    private lateinit var upsertNote: UpsertNote

    @Before
    fun setUp() {
        fakeNotesRepositoryImpl = FakeNoteRepository()
        upsertNote = UpsertNote(fakeNotesRepositoryImpl)
    }

    @Test
    fun `upsert note with empty title, return false`() = runTest {
        val isInserted = upsertNote.invoke(
            title = "",
            description = "description",
            imageUrl = "image"
        )

        assertThat(isInserted).isFalse()
    }

    @Test
    fun `upsert note with empty description, return false`() = runTest {
        val isInserted = upsertNote.invoke(
            title = "title",
            description = "",
            imageUrl = "image"
        )

        assertThat(isInserted).isFalse()
    }

    @Test
    fun `upsert a valid, return true`() = runTest {
        val isInserted = upsertNote.invoke(
            title = "title",
            description = "description",
            imageUrl = "image"
        )

        assertThat(isInserted).isTrue()
    }

}