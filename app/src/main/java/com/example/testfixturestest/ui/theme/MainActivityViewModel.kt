package com.example.testfixturestest.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlib.Person
import com.example.androidlib.PersonService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val personService: PersonService
) : ViewModel() {


    val state: StateFlow<State> =
        personService.getPerson()
            .map {
                State.Loaded(it)
            }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.Loading)

    sealed interface State {
        object Loading : State
        data class Loaded(
            val person: Person
        ) : State
    }

}