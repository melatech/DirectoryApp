package com.melatech.ui.directory.rooms
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melatech.data.source.remote.model.rooms.RoomsAPIResponseItem
import com.melatech.data.source.rooms.IRoomsRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val roomsRepository: IRoomsRepository
) : ViewModel() {

    private val _roomsUiState: MutableStateFlow<List<RoomsAPIResponseItem>> =
        MutableStateFlow(emptyList())
    val roomsUiState: StateFlow<List<RoomsAPIResponseItem>> = _roomsUiState

    init {
        viewModelScope.launch {
            val apiResponse = roomsRepository.getRoomDirectory()
            val roomsDirectory = apiResponse.body()
            println("jason inside vm peopleDirectory: $roomsDirectory")
            roomsDirectory?.let {
                val roomsList = it
                _roomsUiState.value = roomsList
            }
        }
    }
}