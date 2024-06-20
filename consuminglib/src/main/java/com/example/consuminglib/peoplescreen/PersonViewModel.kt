package com.example.consuminglib.peoplescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlib.Person
import com.example.androidlib.PeopleService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    personService: PeopleService
) : ViewModel() {

    val state: StateFlow<State> =
        personService.getPeople()
            .map {
                State.Loaded(it)
            }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.Loading)

    sealed interface State {
        object Loading : State
        data class Loaded(
            val people: List<Person>
        ) : State
    }

}