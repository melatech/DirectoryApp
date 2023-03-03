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

    init {
        viewModelScope.launch {
            val apiResponse = peopleRepository.getPeopleDirectory()
            val peopleDirectory = apiResponse.body()
            println("jason inside vm peopleDirectory: $peopleDirectory")
            peopleDirectory?.let {
                val peopleList = it
                _peopleUiState.value = peopleList
            }
        }
    }
}

//-----------------------------------------------

//init {
//    viewModelScope.launch(IO) {
//        val response = repository.getNewsHeadlines(COUNTRY_NAME, PAGE)
//        val headlines = response.body()
//        headlines?.run {
//            val articleUIModelList = this.articles
//                .map { article ->
//                    ArticleUIModel(
//                        id = article.id ?: 0,
//                        title = article.title ?: "-",
//                        description = article.description ?: "-",
//                        authorName = article.author ?: "-",
//                        formattedPublishedDate = article.publishedAt?.let { publishedDate ->
//                            formatDateTimeUsecase(publishedDate)
//                        } ?: "-",
//                        contentUrl = article.url
//                    )
//                }
//            _newsUIStateFlow.value = articleUIModelList
//        }
//    }
//}
