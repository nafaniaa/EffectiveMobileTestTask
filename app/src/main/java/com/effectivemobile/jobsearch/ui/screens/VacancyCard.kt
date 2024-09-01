package com.effectivemobile.jobsearch.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.data.Vacancy

@Composable
fun VacancyCard(
    vacancy: Vacancy,
    modifier: Modifier
){
   Card(
       modifier = modifier
           .padding(8.dp)
           .fillMaxWidth()
   ) {
       Column(
           horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.Top
       ) {
           vacancy.lookingNumber?.let { 
               Text(
                   text = stringResource(R.string.lookingNow) + "$it" + stringResource(R.string.people),
                   color = Color.Green
               )
           }

           vacancy.title?.let {
               Text(
                   text = it
               )
           }

           vacancy.salary?.full.let {
               Text(
                   text = it.toString()
               )
           }

           vacancy.address?.let {
               Text(
                   text = it.town.toString()
               )
           }

           vacancy.company?.let {
               Text(
                   text = it
               )
           }

           vacancy.experience?.previewText.let {
               Text(
                   text = it.toString()
               )
           }

           vacancy.publishedDate?.let {
               Text(
                   text = it
               )
           }

           Button(onClick = { /*TODO*/ }) {
               Text(stringResource(R.string.respond))
           }

       }

   }
}
