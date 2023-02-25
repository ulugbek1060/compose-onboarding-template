package com.example.movieapp.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.Typography


@Composable
fun CustomItem(
   person: Person
) {
   Row(
      modifier = Modifier
         .background(Color.Yellow)
         .fillMaxWidth()
         .padding(24.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp)
   ) {
      Text(
         text = person.id,
         color = Color.Black,
         fontSize = Typography.h4.fontSize,
         fontWeight = FontWeight.Bold
      )
      Text(
         text = person.age,
         color = Color.Black,
         fontSize = Typography.h5.fontSize,
         fontWeight = FontWeight.Normal
      )
      Text(
         text = person.name,
         color = Color.Black,
         fontSize = Typography.h5.fontSize,
         fontWeight = FontWeight.Normal
      )
   }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader() {
   // TODO: Sticky Header From Lazy Column
   val sections = listOf("A", "B", "S", "D", "E", "F", "G")

   LazyColumn(
      contentPadding = PaddingValues(all = 12.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
   ) {
      sections.forEach { section ->
         stickyHeader {
            Text(
               modifier = Modifier
                  .fillMaxWidth()
                  .background(Color.LightGray)
                  .padding(12.dp),
               text = "Section $section"
            )
         }
         items(10) { item ->
            Text(
               modifier = Modifier.padding(12.dp),
               text = "item from section $item"
            )
         }
      }
   }
}

@Composable
fun CLazyColumn() {
   val personRepository = PersonRepository()
   val persons = personRepository.personList;

   LazyColumn(
      contentPadding = PaddingValues(all = 12.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
   ) {
      itemsIndexed(
         items = persons,
      ) { index, person ->
         CustomItem(person = person)
      }
   }
}


data class Person(
   val id: String,
   val name: String,
   val age: String
)

class PersonRepository {
   val personList = listOf(
      Person(
         id = "1",
         name = "Adam",
         age = "12"
      ),
      Person(
         id = "2",
         name = "Niki",
         age = "23"
      ),
      Person(
         id = "2",
         name = "Sam",
         age = "18"
      ),
      Person(
         id = "3",
         name = "John",
         age = "14"
      ),
      Person(
         id = "4",
         name = "Charlotte",
         age = "22"
      ),
      Person(
         id = "5",
         name = "Susan",
         age = "10"
      ),
      Person(
         id = "6",
         name = "Hyznberg",
         age = "33"
      ),
      Person(
         id = "7",
         name = "Veronica",
         age = "25"
      ),
      Person(
         id = "8",
         name = "Angelina",
         age = "20"
      ),
      Person(
         id = "9",
         name = "Sarah",
         age = "12"
      ),
      Person(
         id = "10",
         name = "Karaline",
         age = "21"
      ),
   )

}