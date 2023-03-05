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
import java.text.SimpleDateFormat
import java.util.*
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
            roomsDirectory?.let {
                val roomsList = it
                val roomsWithFormattedDates = roomsList.map { item ->
                    item.copy(createdAt = formatDate(item.createdAt))
                }
                _roomsUiState.value = roomsWithFormattedDates
            }
        }
    }

    private fun formatDate(createdDate: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return parser.parse(createdDate)?.let {
            formatter.format(it)
        } ?: "-"
    }
}