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

    private val _peopleUiState: MutableStateFlow<List<PeopleAPIResponseItem>> = MutableStateFlow(emptyList())
    val peopleUiState: StateFlow<List<PeopleAPIResponseItem>> = _peopleUiState

    init {
        viewModelScope.launch {
            val apiResponse = peopleRepository.getPeopleDirectory()
            val peopleDirectory = apiResponse.body()
            println("jason inside vm peopleDirectory: $peopleDirectory")

        }
    }



}