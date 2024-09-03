package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.effectivemobile.jobsearch.data.Vacancy

@Composable
fun VacanciesGridScreen(
    vacancies: List<Vacancy>,
    modifier: Modifier
){
    LazyColumn(){
        itemsIndexed(vacancies){ _, vacancy ->
            VacancyCard(vacancy = vacancy, modifier = modifier)
        }

    }

}