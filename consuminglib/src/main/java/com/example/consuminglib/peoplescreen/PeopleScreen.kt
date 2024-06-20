package com.example.consuminglib.peoplescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.androidlib.Person
import com.example.consuminglib.R

@Composable
fun PeopleScreen(
    viewModel: PersonViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    when (val s = state) {
        is PersonViewModel.State.Loading -> Text(text = "Loading")
        is PersonViewModel.State.Loaded -> PeopleList(list = s.people)
    }
}

@Composable
fun PeopleList(
    list: List<Person>
) {
    LazyColumn {
        items(list) { person ->
            Person(person)
        }
    }
}

@Composable
fun Person(p: Person) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        if (LocalInspectionMode.current) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_4_24),
                contentDescription = "image",
                modifier = Modifier.size(64.dp)
            )
        } else {
            AsyncImage(
                model = p.avatar,
                contentDescription = "image",
                modifier = Modifier.size(64.dp)
            )
        }
        Column {
            Text(text = p.name, modifier = Modifier.padding(4.dp))
            Text(text = p.email, modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview
@Composable
fun previewPeople() {
    PeopleList(
        list = listOf(
            Person(1, "Thomas", "http://jpg", "my@emial.com"),
            Person(2, "Michael", "http://jpg", "my@email.com")
        )
    )
}