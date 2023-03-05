package com.melatech.ui.directory.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melatech.data.source.people.IPeopleRepository
import com.melatech.data.source.remote.model.people.PeopleAPIResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peopleRepository: IPeopleRepository
) : ViewModel() {

    private val _peopleUiState: MutableStateFlow<List<PeopleAPIResponseItem>> =
        MutableStateFlow(emptyList())
    val peopleUiState: StateFlow<List<PeopleAPIResponseItem>> = _peopleUiState

    private val _selectedItemUiState: MutableStateFlow<PeopleAPIResponseItem> =
        MutableStateFlow(PeopleAPIResponseItem())
    val selectedItemUiState: StateFlow<PeopleAPIResponseItem> = _selectedItemUiState

    fun emitSelectedPeople(people: PeopleAPIResponseItem){
        _selectedItemUiState.value = people
    }

    init {
        viewModelScope.launch {
            val apiResponse = peopleRepository.getPeopleDirectory()
            val peopleDirectory = apiResponse.body()
            peopleDirectory?.let {
                val peopleList = it
                _peopleUiState.value = peopleList
            }
        }
    }
}


