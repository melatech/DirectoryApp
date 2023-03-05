package com.melatech.ui.directory.people

import app.cash.turbine.test
import com.melatech.MainDispatcherRule
import com.melatech.data.source.people.IPeopleRepository
import com.melatech.data.source.remote.model.people.PeopleAPIResponse
import com.melatech.data.source.remote.model.people.PeopleAPIResponseItem
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
internal class PeopleViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: PeopleViewModel

    private val peopleAPIResponse = PeopleAPIResponse()

    private val repository = mockk<IPeopleRepository> {
        // given
        peopleAPIResponse.add(PeopleAPIResponseItem())
        peopleAPIResponse.add(PeopleAPIResponseItem())
        peopleAPIResponse.add(PeopleAPIResponseItem())
        coEvery { getPeopleDirectory() } returns Response.success(peopleAPIResponse)
    }

    @Before
    fun setUp() {
        viewModel = PeopleViewModel(repository)
    }

    @Test
    fun `viewmodel should emit the list of people from the repository`() {
        runTest {
            // when
            viewModel.peopleUiState.test {
                // then
                assertTrue(awaitItem().size == 3)
            }
        }
    }
}