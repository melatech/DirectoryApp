package com.melatech.ui.directory.rooms

import app.cash.turbine.test
import com.melatech.MainDispatcherRule
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponse
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponseItem
import com.melatech.data.source.rooms.IRoomsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
internal class RoomsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val roomsAPIResponse = RoomsAPIResponse()

    private lateinit var viewModel: RoomsViewModel

    private val repository = mockk<IRoomsRepository> {
        // given
        roomsAPIResponse.add(RoomsAPIResponseItem("2022-01-24T20:52:50.765Z", "1", false, 53539))
        roomsAPIResponse.add(RoomsAPIResponseItem("2022-01-25T14:37:26.128Z", "2", false, 34072))
        coEvery { getRoomDirectory() } returns Response.success(roomsAPIResponse)
    }

    @Before
    fun setUp() {
        viewModel = RoomsViewModel(repository)
    }

    @Test
    fun `viewmodel should emit list with formatted dates`() {
        runTest {
            // when
            viewModel.roomsUiState.test {
                assertEquals(
                    listOf(
                        // then
                        RoomsAPIResponseItem(
                            "24/01/2022",
                            "1",
                            false,
                            53539
                        ),
                        RoomsAPIResponseItem(
                            "25/01/2022",
                            "2",
                            false,
                            34072
                        ),
                    ),
                    awaitItem()
                )
            }
        }
    }
}